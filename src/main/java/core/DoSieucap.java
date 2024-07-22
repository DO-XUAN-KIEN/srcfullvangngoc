package core;

import client.Player;
import event_daily.st;
import io.Message;
import io.Session;
import template.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DoSieucap {

    public static void nangdothan(Session conn, Message m) {
        try {
            if (conn.p.time_speed_rebuild > System.currentTimeMillis()) {
                Service.send_notice_box(conn, "Chậm thôi!");
                return;
            }
            conn.p.time_speed_rebuild = System.currentTimeMillis() + 2000;
            byte type = m.reader().readByte();
            short id = -1;
            byte tem = -1;
            try {
                id = m.reader().readShort();
                tem = m.reader().readByte();
            } catch (IOException e) {
            }
            switch (type) {
                case 0: {
                    try {
                        if (tem != 3) {
                            Service.send_notice_box(conn, "Trang bị không phù hợp!");
                            return;
                        }
                        if (id >= conn.p.item.bag3.length) {
                            return;
                        }
                        Item3 temp = conn.p.item.bag3[id];
                        if (!(temp.id >= 4831 && temp.id <= 4873)) {
                            Service.send_notice_box(conn, "Trang bị không phù hợp!");
                            return;
                        }
                        if (temp.tierStar < 15) {
                            conn.p.TypeItemStarCreate = Helps.ItemStar.ConvertType(temp.type);
                            Message m_send = new Message(-105);
                            m_send.writer().writeByte(4);
                            m_send.writer().writeByte(5);
                            if (conn.p.NLdothan == null || conn.p.NLdothan.length < 5) {
                                conn.p.setnldothan();
                            }
                            int[] values = {10, 12, 14, 16, 18, 20, 22, 24, 26, 28, 30, 32, 34, 36, 38, 40};
                            int tierStar = temp.tierStar >= 0 && temp.tierStar < values.length ? values[temp.tierStar] : temp.tierStar;
                            for (int i = conn.p.TypeItemStarCreate * 5; i < conn.p.TypeItemStarCreate * 5 + 5; i++) {
                                m_send.writer().writeShort(conn.p.NLdothan[i]); // id ở player
                                if (conn.version >= 270) {
                                    m_send.writer().writeShort(tierStar);
                                } else {
                                    m_send.writer().writeByte(tierStar);
                                }
                            }
                            conn.addmsg(m_send);
                            m_send.cleanup();
                        } else {
                            Service.send_notice_box(conn, "Lỗi hãy thử lại!");
                        }
                        conn.p.time_speed_rebuild = 0;
                    } catch (Exception e) {
                        System.out.println("Lỗi: " + e.getMessage());
                        e.printStackTrace();
                    }
                    break;
                }
                case 4: {//nâng cấp tbtt
                    if (id >= conn.p.item.bag3.length || id < 0) {
                        return;
                    }
                    Item3 temp = conn.p.item.bag3[id];
                    if (temp == null && !(temp.id >= 4831 && temp.id <= 4873) && temp.color != 5 && temp.tierStar >= 15) {
                        Service.send_notice_box(conn, "Trang bị không phù hợp!");
                        return;
                    }
                    if (temp != null && temp.id >= 4831 && temp.id <= 4873 && temp.color == 5 && temp.tierStar <= 15) {
                        conn.p.id_Upgrade_Medal_Star = id;
                        Upgrade_dothan(conn, tem);
                    } else {
                        Service.send_notice_box(conn, "Trang bị không phù hợp hoặc đã đạt cấp tối đa!");
                        return;
                    }
                    break;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static final int[] ti_le_nang_do = new int[]{10000, 8000, 4000, 8000, 300, 600, 900, 1200, 1500, 2000, 1111, 1111, 1111, 1111, 1111, 1111};

    public static void Upgrade_dothan(Session conn, byte index) throws IOException { // nâng cấp tt
        try {
            int id = conn.p.id_Upgrade_Medal_Star;
            if (id >= conn.p.item.bag3.length || id < 0) {
                return;
            }
            Item3 temp = conn.p.item.bag3[id];
            if (temp == null && !(temp.id >= 4831 && temp.id <= 4873) && temp.color != 5 && temp.tierStar >= 15) {
                Service.send_notice_box(conn, "Trang bị không phù hợp!");
                return;
            }
            int[] values = {10, 12, 14, 16, 18, 20, 22, 24, 26, 28, 30, 32, 34, 36, 38, 40};
            int tierStar = temp.tierStar >= 0 && temp.tierStar < values.length ? values[temp.tierStar] : temp.tierStar;
            for (int i = conn.p.TypeItemStarCreate * 5; i < conn.p.TypeItemStarCreate * 5 + 5; i++) {
                if (conn.p.item.total_item_by_id(7, conn.p.NLdothan[i]) < tierStar && conn.ac_admin < 20) {
                    Service.send_notice_box(conn, "Thiếu " + ItemTemplate7.item.get(conn.p.NLdothan[i]).getName());
                    return;
                }
            }
            if (conn.p.item.total_item_by_id(7, 471) < 5 && conn.ac_admin < 66) {
                Service.send_notice_box(conn, "Không đủ 5 vật phẩm nâng cấp");
                return;
            }
            if (temp.tierStar >= ti_le_nang_do.length) {
                Service.send_notice_box(conn, "Trang bị đã đạt cấp tối đa!");
                return;
            }
            long vang_req = (temp.tierStar + 1) * 5_000_000;
            int coin_req = (temp.tierStar + 1) * 10_000;
            if (temp.tierStar < 8) {
                if (conn.p.get_vang() < vang_req){
                    Service.send_notice_box(conn,"Không đủ "+vang_req+ "vàng");
                    return;
                }
                conn.p.update_vang(-vang_req);
            }else {
                if (conn.p.checkcoin()< coin_req){
                    Service.send_notice_box(conn,"Không đủ" + coin_req + "coin");
                    return;
                }
                conn.p.update_coin(-coin_req);
            }
            boolean suc = ti_le_nang_do[temp.tierStar] > Util.random(10000);
            if (conn.ac_admin > 3) {
                suc = true;
            }
            if (suc) {
                List<Option> ops = Helps.ItemStar.GetOpsItemStarUpgrade(temp.clazz, temp.type, temp.id, temp.tierStar + 1, temp.op);
                if (ops == null || ops.isEmpty()) {
                    Service.send_notice_box(conn, "Lỗi không tìm thấy chỉ số, hãy chụp lại chỉ số và báo ngay cho ad \"Nhắn riêng\"");
                    return;
                }
                temp.tierStar++;
                temp.UpdateName();
                for (int i = 0; i < temp.op.size(); i++) {
                    Option op = temp.op.get(i);
                    if (op.id >= 0 && op.id <= 99) {
                        op.setParam(op.getParam(4));
                    }
                    if (op != null && op.id >= -128 && op.id <= -80 || (op.id == 99)) {
                        op.setParam(op.getParam(0) + 100);
                    }
                }
            } else {
                if (index == 0) {
                    for (Option o : temp.op) {
                        if (o.id == (byte) 129) {
                            o.param -= 100;
                        }
                    }
                }
            }
            // xóa nl
            for (int i = conn.p.TypeItemStarCreate * 5; i < conn.p.TypeItemStarCreate * 5 + 5; i++) {
                conn.p.item.remove(7, conn.p.NLdothan[i], tierStar);
            }
            if (suc == true) {
                conn.p.item.remove(7, 471, 5);
            } else {
                conn.p.item.remove(7, 471, 2);
            }
            if (suc && (temp.tierStar + 1) % 3 == 0) {
                conn.p.ChangeNL_dothan(conn.p.TypeItemStarCreate);
            }
            conn.p.item.char_inventory(4);
            conn.p.item.char_inventory(7);
            conn.p.item.char_inventory(3);
            Message m = new Message(-105);
            m.writer().writeByte(3);
            if (suc) {
                m.writer().writeByte(3);
                m.writer().writeUTF("Thành công!");
            } else {
                m.writer().writeByte(4);
                m.writer().writeUTF("Thất bại!");
            }
            m.writer().writeByte(3);
            m.writer().writeUTF(temp.name);
            m.writer().writeByte(temp.clazz);
            m.writer().writeShort(temp.id);
            m.writer().writeByte(temp.type);
            m.writer().writeShort(temp.icon);
            m.writer().writeByte(temp.tier); // tier
            m.writer().writeShort(1); // level required
            m.writer().writeByte(temp.color); // color
            m.writer().writeByte(0); // can sell
            m.writer().writeByte(0); // can trade
            m.writer().writeByte(temp.op.size());
            for (int i = 0; i < temp.op.size(); i++) {
                m.writer().writeByte(temp.op.get(i).id);
                m.writer().writeInt(temp.op.get(i).getParam(0));

            }
            m.writer().writeInt(0); // time use
            m.writer().writeByte(0);
            m.writer().writeByte(0);
            m.writer().writeByte(0);
            conn.addmsg(m);
            m.cleanup();
            if (temp.tierStar < 15) {
                m = new Message(-105);
                m.writer().writeByte(5);
                if (suc) {
                    m.writer().writeByte(3);
                    m.writer().writeUTF("Thành công, xin chúc mừng :)");
                } else {
                    m.writer().writeByte(4);
                    m.writer().writeUTF("Thất bại rồi :(");
                }
                m.writer().writeShort(id);
                conn.addmsg(m);
                m.cleanup();
            }
        } catch (Exception eee) {
            System.out.println("Lỗi: " + eee.getMessage());
            eee.printStackTrace();
        }
    }
    public static short[] ti_le_nang_md = new short[]{10000, 10000, 10000, 6666, 5555, 4444, 3333, 2222, 1111, 500, 300, 200, 50, 1, 1,10000, 10000, 10000, 6666, 5555, 4444, 3333, 2222, 1111, 500, 300, 200, 50, 1, 1, 1, 10000, 10000, 10000, 6666, 5555, 4444, 3333, 2222, 1111, 500, 300, 200, 50, 1, 1, 1};
    public static void nangmdthan(Session conn, Message m) {
        try {
            if (conn.p.time_speed_rebuild > System.currentTimeMillis()) {
                Service.send_notice_box(conn, "Chậm thôi!");
                return;
            }
            conn.p.time_speed_rebuild = System.currentTimeMillis() + 1000;
            byte type = m.reader().readByte();
            short id = -1;
            byte cat = -1;
            try {
                id = m.reader().readShort();
                cat = m.reader().readByte();
            } catch (IOException e) {
            }
            switch (type) {
                case 0: {
                    if (cat != 3) {
                        Service.send_notice_box(conn, "Trang bị không phù hợp!");
                        return;
                    }
                    if (id >= conn.p.item.bag3.length) {
                        return;
                    }
                    Item3 item = conn.p.item.bag3[id];
                    if (item == null || item.tier < 15 || item.color < 4) {
                        Service.send_notice_box(conn, "Mề Đay Cam + 15 trở Lên!");
                        return;
                    }
                    if (item != null) {
                        if (item.type == 16) {
                            if (item.tier < 30) {
                                Message m_send = new Message(-105);
                                m_send.writer().writeByte(4);
                                m_send.writer().writeByte(5);
                                int[] values = {10, 12, 14, 16, 18, 20, 22, 24, 26, 28, 30, 32, 34, 36, 38, 40};
                                int tier = item.tierStar >= 0 && item.tierStar < values.length ? values[item.tierStar] : item.tierStar;
                                for (short nl : conn.p.NLdothan) {
                                    m_send.writer().writeShort(nl);
                                    if (conn.version >= 270) {
                                        m_send.writer().writeShort(tier);
                                    } else {
                                        m_send.writer().writeByte(tier);
                                    }
                                }
                                conn.addmsg(m_send);
                                m_send.cleanup();
                            } else {
                                Service.send_notice_box(conn, "Trang bị đã nâng tối đa");
                            }
                        } else {
                            Service.send_notice_box(conn, "Vật phẩm không phù hợp");
                        }
                    } else {
                        Service.send_notice_box(conn, "Vui lòng chọn Mề Đay để Nâng Cấp");
                    }
                    break;
                }
                case 4: {
                    if (cat != 3) {
                        return;
                    }
                    if (id >= conn.p.item.bag3.length) {
                        return;
                    }
                    Item3 item = conn.p.item.bag3[id];

                    if (item == null || item.tier < 15 || item.color < 4) {
                        Service.send_notice_box(conn, "Mề Đay Cam + 15 trở Lên!");
                        return;
                    }
                    if (item != null && item.type == 16 && item.tier < 30) {
                        int[] values = {10, 12, 14, 16, 18, 20, 22, 24, 26, 28, 30, 32, 34, 36, 38, 40};
                        int tier = item.tierStar >= 0 && item.tierStar < values.length ? values[item.tierStar] : item.tierStar;
                        for (int i = 0; i < 5; i++) {
                            if (i < conn.p.NLdothan.length) {
                                if (conn.p.item.total_item_by_id(7, conn.p.NLdothan[i]) < tier && (conn.ac_admin < 4 || !Manager.BuffAdmin)) {
                                    Service.send_notice_box(conn, "Không đủ " + ItemTemplate7.item.get(conn.p.NLdothan[i]).getName() + "!");
                                    return;
                                }
                            }
                        }
                        for (int i = 0; i < 5; i++) {
                            if (i < conn.p.NLdothan.length) {
                                conn.p.item.remove(7, conn.p.NLdothan[i], tier);
                            }
                        }
                        boolean suc;
                        if (item.tier >= 15 && item.tier <= 30) {
                            suc = Util.random(11000) < ti_le_nang_md[item.tier - 15] || (conn.ac_admin > 3 && Manager.BuffAdmin);
                        } else {
                            suc = ti_le_nang_md[item.tier] > Util.random(11000) || (conn.ac_admin > 3 && Manager.BuffAdmin);
                        }
                        if (suc) {
                            item = Helps.medal.Upgare_Medal(item);
                            //item.color = 5;
                            item.tier++;
                            item.tierStar++;
                            //item.icon = 13188;
                            item.UpdateName();
                            conn.p.setnldothan();
                        }
                        m.cleanup();
                        m = new Message(-105);
                        m.writer().writeByte(3);
                        if (suc) {
                            m.writer().writeByte(3);
                            m.writer().writeUTF("Thành công!");
                        } else {
                            m.writer().writeByte(4);
                            m.writer().writeUTF("Thất bại!");
                        }
                        // Record information about the upgraded equipment
                        ItemTemplate3 temp = ItemTemplate3.item.get(item.id);
                        m.writer().writeByte(3);
                        m.writer().writeUTF(item.name);
                        m.writer().writeByte(temp.getClazz());
                        m.writer().writeShort(temp.getId());
                        m.writer().writeByte(temp.getType());
                        m.writer().writeShort(temp.getIcon());
                        m.writer().writeByte(item.tier); // tier
                        m.writer().writeShort(1); // level required
                        m.writer().writeByte(item.color); // color
                        m.writer().writeByte(0); // can sell
                        m.writer().writeByte(0); // can trade
                        m.writer().writeByte(item.op.size());
                        for (int i = 0; i < item.op.size(); i++) {
                            m.writer().writeByte(item.op.get(i).id);
                            m.writer().writeInt(item.op.get(i).getParam(item.tier));
                        }
                        m.writer().writeInt(0); // time use
                        m.writer().writeByte(0);
                        m.writer().writeByte(0);
                        m.writer().writeByte(0);
                        conn.addmsg(m);
                        m.cleanup();

                        // Update character inventory
                        conn.p.item.char_inventory(4);
                        conn.p.item.char_inventory(7);
                        conn.p.item.char_inventory(3);

                        // Send upgrade result notice
                        m = new Message(-105);
                        m.writer().writeByte(5);
                        if (suc) {
                            m.writer().writeByte(3);
                            m.writer().writeUTF("Thành công!");
                        } else {
                            m.writer().writeByte(4);
                            m.writer().writeUTF("Thất bại!");
                        }
                        m.writer().writeShort(id);
                        conn.addmsg(m);
                        m.cleanup();
                    } else {
                        Service.send_notice_box(conn, "Trang Bị đã đạt cấp tối đa!");
                    }
                    break;
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}