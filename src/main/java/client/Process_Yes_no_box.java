package client;

import core.*;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import event_daily.ChiemThanhManager;
import event_daily.Wedding;

import io.Message;
import io.Session;
import map.Dungeon;
import map.DungeonManager;
import map.Map;
import map.MapService;
import template.*;

public class Process_Yes_no_box {
    public static void process(Session conn, Message m) throws IOException {
        short id = m.reader().readShort(); // id
        if (id != conn.p.index) {
            return;
        
        }
        int type = m.reader().readByte(); // type
        byte value = m.reader().readByte(); // value
        if (value != 1) {
            switch (type) {
               case 110: {
					Player p0 = Map.get_player_by_name(conn.p.in4_wedding[1]);
					Service.send_notice_box(p0.conn, "rất tiếc " + conn.p.name + " đã từ chối lời cầu hôn của bạn");
					conn.p.in4_wedding = null;
					break;
				}
                //vip 1
                case -100: {
                    if(conn.p.item.get_bag_able()< 1){
                        Service.send_notice_box(conn,"Hành trang đầy!!!");
                        return;
                    }
                    if(conn.p.item.total_item_by_id(7,111)< 100){
                        Service.send_notice_box(conn,"Không đủ số lượng!!");
                        return;
                    }
                    conn.p.item.remove(7,111,100);
                    short iditem = 1000;
                    Item3 itbag = new Item3();
                    itbag.id = iditem;
                    itbag.name = ItemTemplate3.item.get(iditem).getName();
                    itbag.clazz = ItemTemplate3.item.get(iditem).getClazz();
                    itbag.type = ItemTemplate3.item.get(iditem).getType();
                    itbag.level = ItemTemplate3.item.get(iditem).getLevel();
                    itbag.icon = ItemTemplate3.item.get(iditem).getIcon();
                    itbag.op = new ArrayList<>();
                    itbag.op.addAll(ItemTemplate3.item.get(iditem).getOp());
                    itbag.color = ItemTemplate3.item.get(iditem).getColor();
                    itbag.part = ItemTemplate3.item.get(iditem).getPart();
                    itbag.tier = 0;
                    itbag.islock = true;
                    itbag.time_use = 0;
                    conn.p.item.add_item_bag3(itbag);
                    conn.p.item.char_inventory(5);
                    conn.p.item.char_inventory(7);
                    List<box_item_template> ids = new ArrayList<>();
                    ids.add(new box_item_template(iditem, (short) 1, (byte) 3));
                    Service.Show_open_box_notice_item(conn.p, "Bạn nhận được", ids);
                    break;
                }
                case -101: {
                    if(conn.p.item.get_bag_able()< 1){
                        Service.send_notice_box(conn,"Hành trang đầy!!!");
                        return;
                    }
                    if(conn.p.item.total_item_by_id(7,495)< 100){
                        Service.send_notice_box(conn,"Không đủ số lượng!!");
                        return;
                    }
                    conn.p.item.remove(7,495,100);
                    short iditem = 4819;
                    Item3 itbag = new Item3();
                    itbag.id = iditem;
                    itbag.name = ItemTemplate3.item.get(iditem).getName();
                    itbag.clazz = ItemTemplate3.item.get(iditem).getClazz();
                    itbag.type = ItemTemplate3.item.get(iditem).getType();
                    itbag.level = ItemTemplate3.item.get(iditem).getLevel();
                    itbag.icon = ItemTemplate3.item.get(iditem).getIcon();
                    itbag.op = new ArrayList<>();
                    itbag.op.addAll(ItemTemplate3.item.get(iditem).getOp());
                    itbag.color = ItemTemplate3.item.get(iditem).getColor();
                    itbag.part = ItemTemplate3.item.get(iditem).getPart();
                    itbag.tier = 0;
                    itbag.islock = true;
                    itbag.time_use = 0;
                    conn.p.item.add_item_bag3(itbag);
                    conn.p.item.char_inventory(5);
                    conn.p.item.char_inventory(7);
                    List<box_item_template> ids = new ArrayList<>();
                    ids.add(new box_item_template(iditem, (short) 1, (byte) 3));
                    Service.Show_open_box_notice_item(conn.p, "Bạn nhận được", ids);
                    break;
                }
                case -102: {
                    if(conn.p.item.get_bag_able()< 1){
                        Service.send_notice_box(conn,"Hành trang đầy!!!");
                        return;
                    }
                    if(conn.p.item.total_item_by_id(7,495)< 100){
                        Service.send_notice_box(conn,"Không đủ số lượng!!");
                        return;
                    }
                    conn.p.item.remove(7,495,100);
                    short iditem = 4822;
                    Item3 itbag = new Item3();
                    itbag.id = iditem;
                    itbag.name = ItemTemplate3.item.get(iditem).getName();
                    itbag.clazz = ItemTemplate3.item.get(iditem).getClazz();
                    itbag.type = ItemTemplate3.item.get(iditem).getType();
                    itbag.level = ItemTemplate3.item.get(iditem).getLevel();
                    itbag.icon = ItemTemplate3.item.get(iditem).getIcon();
                    itbag.op = new ArrayList<>();
                    itbag.op.addAll(ItemTemplate3.item.get(iditem).getOp());
                    itbag.color = ItemTemplate3.item.get(iditem).getColor();
                    itbag.part = ItemTemplate3.item.get(iditem).getPart();
                    itbag.tier = 0;
                    itbag.islock = true;
                    itbag.time_use = 0;
                    conn.p.item.add_item_bag3(itbag);
                    conn.p.item.char_inventory(5);
                    conn.p.item.char_inventory(7);
                    List<box_item_template> ids = new ArrayList<>();
                    ids.add(new box_item_template(iditem, (short) 1, (byte) 3));
                    Service.Show_open_box_notice_item(conn.p, "Bạn nhận được", ids);
                    break;
                }
                case -103: {
                    if(conn.p.item.get_bag_able()< 1){
                        Service.send_notice_box(conn,"Hành trang đầy!!!");
                        return;
                    }
                    if(conn.p.item.total_item_by_id(7,495)< 100){
                        Service.send_notice_box(conn,"Không đủ số lượng!!");
                        return;
                    }
                    conn.p.item.remove(7,495,100);
                    short iditem = 4823;
                    Item3 itbag = new Item3();
                    itbag.id = iditem;
                    itbag.name = ItemTemplate3.item.get(iditem).getName();
                    itbag.clazz = ItemTemplate3.item.get(iditem).getClazz();
                    itbag.type = ItemTemplate3.item.get(iditem).getType();
                    itbag.level = ItemTemplate3.item.get(iditem).getLevel();
                    itbag.icon = ItemTemplate3.item.get(iditem).getIcon();
                    itbag.op = new ArrayList<>();
                    itbag.op.addAll(ItemTemplate3.item.get(iditem).getOp());
                    itbag.color = ItemTemplate3.item.get(iditem).getColor();
                    itbag.part = ItemTemplate3.item.get(iditem).getPart();
                    itbag.tier = 0;
                    itbag.islock = true;
                    itbag.time_use = 0;
                    conn.p.item.add_item_bag3(itbag);
                    conn.p.item.char_inventory(5);
                    conn.p.item.char_inventory(7);
                    List<box_item_template> ids = new ArrayList<>();
                    ids.add(new box_item_template(iditem, (short) 1, (byte) 3));
                    Service.Show_open_box_notice_item(conn.p, "Bạn nhận được", ids);
                    break;
                }
                case -104: {
                    if(conn.p.item.get_bag_able()< 1){
                        Service.send_notice_box(conn,"Hành trang đầy!!!");
                        return;
                    }
                    if(conn.p.item.total_item_by_id(7,495)< 100){
                        Service.send_notice_box(conn,"Không đủ số lượng!!");
                        return;
                    }
                    conn.p.item.remove(7,495,100);
                    short iditem = 4824;
                    Item3 itbag = new Item3();
                    itbag.id = iditem;
                    itbag.name = ItemTemplate3.item.get(iditem).getName();
                    itbag.clazz = ItemTemplate3.item.get(iditem).getClazz();
                    itbag.type = ItemTemplate3.item.get(iditem).getType();
                    itbag.level = ItemTemplate3.item.get(iditem).getLevel();
                    itbag.icon = ItemTemplate3.item.get(iditem).getIcon();
                    itbag.op = new ArrayList<>();
                    itbag.op.addAll(ItemTemplate3.item.get(iditem).getOp());
                    itbag.color = ItemTemplate3.item.get(iditem).getColor();
                    itbag.part = ItemTemplate3.item.get(iditem).getPart();
                    itbag.tier = 0;
                    itbag.islock = true;
                    itbag.time_use = 0;
                    conn.p.item.add_item_bag3(itbag);
                    conn.p.item.char_inventory(5);
                    conn.p.item.char_inventory(7);
                    List<box_item_template> ids = new ArrayList<>();
                    ids.add(new box_item_template(iditem, (short) 1, (byte) 3));
                    Service.Show_open_box_notice_item(conn.p, "Bạn nhận được", ids);
                    break;
                }
                case -105: {
                    if(conn.p.item.get_bag_able()< 1){
                        Service.send_notice_box(conn,"Hành trang đầy!!!");
                        return;
                    }
                    if(conn.p.item.total_item_by_id(7,495)< 100){
                        Service.send_notice_box(conn,"Không đủ số lượng!!");
                        return;
                    }
                    conn.p.item.remove(7,495,100);
                    short iditem = 4827;
                    Item3 itbag = new Item3();
                    itbag.id = iditem;
                    itbag.name = ItemTemplate3.item.get(iditem).getName();
                    itbag.clazz = ItemTemplate3.item.get(iditem).getClazz();
                    itbag.type = ItemTemplate3.item.get(iditem).getType();
                    itbag.level = ItemTemplate3.item.get(iditem).getLevel();
                    itbag.icon = ItemTemplate3.item.get(iditem).getIcon();
                    itbag.op = new ArrayList<>();
                    itbag.op.addAll(ItemTemplate3.item.get(iditem).getOp());
                    itbag.color = ItemTemplate3.item.get(iditem).getColor();
                    itbag.part = ItemTemplate3.item.get(iditem).getPart();
                    itbag.tier = 0;
                    itbag.islock = true;
                    itbag.time_use = 0;
                    conn.p.item.add_item_bag3(itbag);
                    conn.p.item.char_inventory(5);
                    conn.p.item.char_inventory(7);
                    List<box_item_template> ids = new ArrayList<>();
                    ids.add(new box_item_template(iditem, (short) 1, (byte) 3));
                    Service.Show_open_box_notice_item(conn.p, "Bạn nhận được", ids);
                    break;
                }
                case -106: {
                    if(conn.p.item.get_bag_able()< 1){
                        Service.send_notice_box(conn,"Hành trang đầy!!!");
                        return;
                    }
                    if(conn.p.item.total_item_by_id(7,495)< 100){
                        Service.send_notice_box(conn,"Không đủ số lượng!!");
                        return;
                    }
                    conn.p.item.remove(7,495,100);
                    short iditem = 4830;
                    Item3 itbag = new Item3();
                    itbag.id = iditem;
                    itbag.name = ItemTemplate3.item.get(iditem).getName();
                    itbag.clazz = ItemTemplate3.item.get(iditem).getClazz();
                    itbag.type = ItemTemplate3.item.get(iditem).getType();
                    itbag.level = ItemTemplate3.item.get(iditem).getLevel();
                    itbag.icon = ItemTemplate3.item.get(iditem).getIcon();
                    itbag.op = new ArrayList<>();
                    itbag.op.addAll(ItemTemplate3.item.get(iditem).getOp());
                    itbag.color = ItemTemplate3.item.get(iditem).getColor();
                    itbag.part = ItemTemplate3.item.get(iditem).getPart();
                    itbag.tier = 0;
                    itbag.islock = true;
                    itbag.time_use = 0;
                    conn.p.item.add_item_bag3(itbag);
                    conn.p.item.char_inventory(5);
                    conn.p.item.char_inventory(7);
                    List<box_item_template> ids = new ArrayList<>();
                    ids.add(new box_item_template(iditem, (short) 1, (byte) 3));
                    Service.Show_open_box_notice_item(conn.p, "Bạn nhận được", ids);
                    break;
                }
                // vip 2
                case -150: {
                    if(conn.p.item.get_bag_able()< 1){
                        Service.send_notice_box(conn,"Hành trang đầy!!!");
                        return;
                    }
                    if(conn.p.item.total_item_by_id(7,495)< 300){
                        Service.send_notice_box(conn,"Không đủ số lượng!!");
                        return;
                    }
                    conn.p.item.remove(7,495,300);
                    short iditem = 4817;
                    Item3 itbag = new Item3();
                    itbag.id = iditem;
                    itbag.name = ItemTemplate3.item.get(iditem).getName();
                    itbag.clazz = ItemTemplate3.item.get(iditem).getClazz();
                    itbag.type = ItemTemplate3.item.get(iditem).getType();
                    itbag.level = ItemTemplate3.item.get(iditem).getLevel();
                    itbag.icon = ItemTemplate3.item.get(iditem).getIcon();
                    itbag.op = new ArrayList<>();
                    itbag.op.addAll(ItemTemplate3.item.get(iditem).getOp());
                    itbag.color = ItemTemplate3.item.get(iditem).getColor();
                    itbag.part = ItemTemplate3.item.get(iditem).getPart();
                    itbag.tier = 0;
                    itbag.islock = true;
                    itbag.time_use = 0;
                    conn.p.item.add_item_bag3(itbag);
                    conn.p.item.char_inventory(5);
                    conn.p.item.char_inventory(7);
                    List<box_item_template> ids = new ArrayList<>();
                    ids.add(new box_item_template(iditem, (short) 1, (byte) 3));
                    Service.Show_open_box_notice_item(conn.p, "Bạn nhận được", ids);
                    Manager.gI().chatKTGprocess("Chúc mừng "+ conn.p.name + " đổi thành công " + itbag.name);
                    break;
                }
                case -151: {
                    if(conn.p.item.get_bag_able()< 1){
                        Service.send_notice_box(conn,"Hành trang đầy!!!");
                        return;
                    }
                    if(conn.p.item.total_item_by_id(7,495)< 300){
                        Service.send_notice_box(conn,"Không đủ số lượng!!");
                        return;
                    }
                    conn.p.item.remove(7,495,300);
                    short iditem = 4820;
                    Item3 itbag = new Item3();
                    itbag.id = iditem;
                    itbag.name = ItemTemplate3.item.get(iditem).getName();
                    itbag.clazz = ItemTemplate3.item.get(iditem).getClazz();
                    itbag.type = ItemTemplate3.item.get(iditem).getType();
                    itbag.level = ItemTemplate3.item.get(iditem).getLevel();
                    itbag.icon = ItemTemplate3.item.get(iditem).getIcon();
                    itbag.op = new ArrayList<>();
                    itbag.op.addAll(ItemTemplate3.item.get(iditem).getOp());
                    itbag.color = ItemTemplate3.item.get(iditem).getColor();
                    itbag.part = ItemTemplate3.item.get(iditem).getPart();
                    itbag.tier = 0;
                    itbag.islock = true;
                    itbag.time_use = 0;
                    conn.p.item.add_item_bag3(itbag);
                    conn.p.item.char_inventory(5);
                    conn.p.item.char_inventory(7);
                    List<box_item_template> ids = new ArrayList<>();
                    ids.add(new box_item_template(iditem, (short) 1, (byte) 3));
                    Service.Show_open_box_notice_item(conn.p, "Bạn nhận được", ids);
                    Manager.gI().chatKTGprocess("Chúc mừng "+ conn.p.name + " đổi thành công " + itbag.name);
                    break;
                }
                case -152: {
                    if(conn.p.item.get_bag_able()< 1){
                        Service.send_notice_box(conn,"Hành trang đầy!!!");
                        return;
                    }
                    if(conn.p.item.total_item_by_id(7,495)< 300){
                        Service.send_notice_box(conn,"Không đủ số lượng!!");
                        return;
                    }
                    conn.p.item.remove(7,495,300);
                    short iditem = 4825;
                    Item3 itbag = new Item3();
                    itbag.id = iditem;
                    itbag.name = ItemTemplate3.item.get(iditem).getName();
                    itbag.clazz = ItemTemplate3.item.get(iditem).getClazz();
                    itbag.type = ItemTemplate3.item.get(iditem).getType();
                    itbag.level = ItemTemplate3.item.get(iditem).getLevel();
                    itbag.icon = ItemTemplate3.item.get(iditem).getIcon();
                    itbag.op = new ArrayList<>();
                    itbag.op.addAll(ItemTemplate3.item.get(iditem).getOp());
                    itbag.color = ItemTemplate3.item.get(iditem).getColor();
                    itbag.part = ItemTemplate3.item.get(iditem).getPart();
                    itbag.tier = 0;
                    itbag.islock = true;
                    itbag.time_use = 0;
                    conn.p.item.add_item_bag3(itbag);
                    conn.p.item.char_inventory(5);
                    conn.p.item.char_inventory(7);
                    List<box_item_template> ids = new ArrayList<>();
                    ids.add(new box_item_template(iditem, (short) 1, (byte) 3));
                    Service.Show_open_box_notice_item(conn.p, "Bạn nhận được", ids);
                    Manager.gI().chatKTGprocess("Chúc mừng "+ conn.p.name + " đổi thành công " + itbag.name);
                    break;
                }
                case -153: {
                    if(conn.p.item.get_bag_able()< 1){
                        Service.send_notice_box(conn,"Hành trang đầy!!!");
                        return;
                    }
                    if(conn.p.item.total_item_by_id(7,495)< 300){
                        Service.send_notice_box(conn,"Không đủ số lượng!!");
                        return;
                    }
                    conn.p.item.remove(7,495,300);
                    short iditem = 4828;
                    Item3 itbag = new Item3();
                    itbag.id = iditem;
                    itbag.name = ItemTemplate3.item.get(iditem).getName();
                    itbag.clazz = ItemTemplate3.item.get(iditem).getClazz();
                    itbag.type = ItemTemplate3.item.get(iditem).getType();
                    itbag.level = ItemTemplate3.item.get(iditem).getLevel();
                    itbag.icon = ItemTemplate3.item.get(iditem).getIcon();
                    itbag.op = new ArrayList<>();
                    itbag.op.addAll(ItemTemplate3.item.get(iditem).getOp());
                    itbag.color = ItemTemplate3.item.get(iditem).getColor();
                    itbag.part = ItemTemplate3.item.get(iditem).getPart();
                    itbag.tier = 0;
                    itbag.islock = true;
                    itbag.time_use = 0;
                    conn.p.item.add_item_bag3(itbag);
                    conn.p.item.char_inventory(5);
                    conn.p.item.char_inventory(7);
                    List<box_item_template> ids = new ArrayList<>();
                    ids.add(new box_item_template(iditem, (short) 1, (byte) 3));
                    Service.Show_open_box_notice_item(conn.p, "Bạn nhận được", ids);
                    Manager.gI().chatKTGprocess("Chúc mừng "+ conn.p.name + " đổi thành công " + itbag.name);
                    break;
                }
                case -154: {
                    if(conn.p.item.get_bag_able()< 1){
                        Service.send_notice_box(conn,"Hành trang đầy!!!");
                        return;
                    }
                    if(conn.p.item.total_item_by_id(7,495)< 300){
                        Service.send_notice_box(conn,"Không đủ số lượng!!");
                        return;
                    }
                    conn.p.item.remove(7,495,300);
                    short iditem = 4831;
                    Item3 itbag = new Item3();
                    itbag.id = iditem;
                    itbag.name = ItemTemplate3.item.get(iditem).getName();
                    itbag.clazz = ItemTemplate3.item.get(iditem).getClazz();
                    itbag.type = ItemTemplate3.item.get(iditem).getType();
                    itbag.level = ItemTemplate3.item.get(iditem).getLevel();
                    itbag.icon = ItemTemplate3.item.get(iditem).getIcon();
                    itbag.op = new ArrayList<>();
                    itbag.op.addAll(ItemTemplate3.item.get(iditem).getOp());
                    itbag.color = ItemTemplate3.item.get(iditem).getColor();
                    itbag.part = ItemTemplate3.item.get(iditem).getPart();
                    itbag.tier = 0;
                    itbag.islock = true;
                    itbag.time_use = 0;
                    conn.p.item.add_item_bag3(itbag);
                    conn.p.item.char_inventory(5);
                    conn.p.item.char_inventory(7);
                    List<box_item_template> ids = new ArrayList<>();
                    ids.add(new box_item_template(iditem, (short) 1, (byte) 3));
                    Service.Show_open_box_notice_item(conn.p, "Bạn nhận được", ids);
                    Manager.gI().chatKTGprocess("Chúc mừng "+ conn.p.name + " đổi thành công " + itbag.name);
                    break;
                }
                //vip 3
                case -200: {
                    if(conn.p.item.get_bag_able()< 1){
                        Service.send_notice_box(conn,"Hành trang đầy!!!");
                        return;
                    }
                    if(conn.p.item.total_item_by_id(7,495)< 500){
                        Service.send_notice_box(conn,"Không đủ số lượng!!");
                        return;
                    }
                    conn.p.item.remove(7,495,500);
                    short iditem = 4816;
                    Item3 itbag = new Item3();
                    itbag.id = iditem;
                    itbag.name = ItemTemplate3.item.get(iditem).getName();
                    itbag.clazz = ItemTemplate3.item.get(iditem).getClazz();
                    itbag.type = ItemTemplate3.item.get(iditem).getType();
                    itbag.level = ItemTemplate3.item.get(iditem).getLevel();
                    itbag.icon = ItemTemplate3.item.get(iditem).getIcon();
                    itbag.op = new ArrayList<>();
                    itbag.op.addAll(ItemTemplate3.item.get(iditem).getOp());
                    itbag.color = ItemTemplate3.item.get(iditem).getColor();
                    itbag.part = ItemTemplate3.item.get(iditem).getPart();
                    itbag.tier = 0;
                    itbag.islock = true;
                    itbag.time_use = 0;
                    conn.p.item.add_item_bag3(itbag);
                    conn.p.item.char_inventory(5);
                    conn.p.item.char_inventory(7);
                    List<box_item_template> ids = new ArrayList<>();
                    ids.add(new box_item_template(iditem, (short) 1, (byte) 3));
                    Service.Show_open_box_notice_item(conn.p, "Bạn nhận được", ids);
                    Manager.gI().chatKTGprocess("Chúc mừng "+ conn.p.name + " đổi thành công " + itbag.name);
                    break;
                }
                case -201: {
                    if(conn.p.item.get_bag_able()< 1){
                        Service.send_notice_box(conn,"Hành trang đầy!!!");
                        return;
                    }
                    if(conn.p.item.total_item_by_id(7,495)< 500){
                        Service.send_notice_box(conn,"Không đủ số lượng!!");
                        return;
                    }
                    conn.p.item.remove(7,495,500);
                    short iditem = 4821;
                    Item3 itbag = new Item3();
                    itbag.id = iditem;
                    itbag.name = ItemTemplate3.item.get(iditem).getName();
                    itbag.clazz = ItemTemplate3.item.get(iditem).getClazz();
                    itbag.type = ItemTemplate3.item.get(iditem).getType();
                    itbag.level = ItemTemplate3.item.get(iditem).getLevel();
                    itbag.icon = ItemTemplate3.item.get(iditem).getIcon();
                    itbag.op = new ArrayList<>();
                    itbag.op.addAll(ItemTemplate3.item.get(iditem).getOp());
                    itbag.color = ItemTemplate3.item.get(iditem).getColor();
                    itbag.part = ItemTemplate3.item.get(iditem).getPart();
                    itbag.tier = 0;
                    itbag.islock = true;
                    itbag.time_use = 0;
                    conn.p.item.add_item_bag3(itbag);
                    conn.p.item.char_inventory(5);
                    conn.p.item.char_inventory(7);
                    List<box_item_template> ids = new ArrayList<>();
                    ids.add(new box_item_template(iditem, (short) 1, (byte) 3));
                    Service.Show_open_box_notice_item(conn.p, "Bạn nhận được", ids);
                    Manager.gI().chatKTGprocess("Chúc mừng "+ conn.p.name + " đổi thành công " + itbag.name);
                    break;
                }
                case -202: {
                    if(conn.p.item.get_bag_able()< 1){
                        Service.send_notice_box(conn,"Hành trang đầy!!!");
                        return;
                    }
                    if(conn.p.item.total_item_by_id(7,495)< 500){
                        Service.send_notice_box(conn,"Không đủ số lượng!!");
                        return;
                    }
                    conn.p.item.remove(7,495,500);
                    short iditem = 4826;
                    Item3 itbag = new Item3();
                    itbag.id = iditem;
                    itbag.name = ItemTemplate3.item.get(iditem).getName();
                    itbag.clazz = ItemTemplate3.item.get(iditem).getClazz();
                    itbag.type = ItemTemplate3.item.get(iditem).getType();
                    itbag.level = ItemTemplate3.item.get(iditem).getLevel();
                    itbag.icon = ItemTemplate3.item.get(iditem).getIcon();
                    itbag.op = new ArrayList<>();
                    itbag.op.addAll(ItemTemplate3.item.get(iditem).getOp());
                    itbag.color = ItemTemplate3.item.get(iditem).getColor();
                    itbag.part = ItemTemplate3.item.get(iditem).getPart();
                    itbag.tier = 0;
                    itbag.islock = true;
                    itbag.time_use = 0;
                    conn.p.item.add_item_bag3(itbag);
                    conn.p.item.char_inventory(5);
                    conn.p.item.char_inventory(7);
                    List<box_item_template> ids = new ArrayList<>();
                    ids.add(new box_item_template(iditem, (short) 1, (byte) 3));
                    Service.Show_open_box_notice_item(conn.p, "Bạn nhận được", ids);
                    Manager.gI().chatKTGprocess("Chúc mừng "+ conn.p.name + " đổi thành công " + itbag.name);
                    break;
                }
                case -203: {
                    if(conn.p.item.get_bag_able()< 1){
                        Service.send_notice_box(conn,"Hành trang đầy!!!");
                        return;
                    }
                    if(conn.p.item.total_item_by_id(7,495)< 500){
                        Service.send_notice_box(conn,"Không đủ số lượng!!");
                        return;
                    }
                    conn.p.item.remove(7,495,500);
                    short iditem = 4829;
                    Item3 itbag = new Item3();
                    itbag.id = iditem;
                    itbag.name = ItemTemplate3.item.get(iditem).getName();
                    itbag.clazz = ItemTemplate3.item.get(iditem).getClazz();
                    itbag.type = ItemTemplate3.item.get(iditem).getType();
                    itbag.level = ItemTemplate3.item.get(iditem).getLevel();
                    itbag.icon = ItemTemplate3.item.get(iditem).getIcon();
                    itbag.op = new ArrayList<>();
                    itbag.op.addAll(ItemTemplate3.item.get(iditem).getOp());
                    itbag.color = ItemTemplate3.item.get(iditem).getColor();
                    itbag.part = ItemTemplate3.item.get(iditem).getPart();
                    itbag.tier = 0;
                    itbag.islock = true;
                    itbag.time_use = 0;
                    conn.p.item.add_item_bag3(itbag);
                    conn.p.item.char_inventory(5);
                    conn.p.item.char_inventory(7);
                    List<box_item_template> ids = new ArrayList<>();
                    ids.add(new box_item_template(iditem, (short) 1, (byte) 3));
                    Service.Show_open_box_notice_item(conn.p, "Bạn nhận được", ids);
                    Manager.gI().chatKTGprocess("Chúc mừng "+ conn.p.name + " đổi thành công " + itbag.name);
                    break;
                }
                case -204: {
                    if(conn.p.item.get_bag_able()< 1){
                        Service.send_notice_box(conn,"Hành trang đầy!!!");
                        return;
                    }
                    if(conn.p.item.total_item_by_id(7,495)< 500){
                        Service.send_notice_box(conn,"Không đủ số lượng!!");
                        return;
                    }
                    conn.p.item.remove(7,495,500);
                    short iditem = 4832;
                    Item3 itbag = new Item3();
                    itbag.id = iditem;
                    itbag.name = ItemTemplate3.item.get(iditem).getName();
                    itbag.clazz = ItemTemplate3.item.get(iditem).getClazz();
                    itbag.type = ItemTemplate3.item.get(iditem).getType();
                    itbag.level = ItemTemplate3.item.get(iditem).getLevel();
                    itbag.icon = ItemTemplate3.item.get(iditem).getIcon();
                    itbag.op = new ArrayList<>();
                    itbag.op.addAll(ItemTemplate3.item.get(iditem).getOp());
                    itbag.color = ItemTemplate3.item.get(iditem).getColor();
                    itbag.part = ItemTemplate3.item.get(iditem).getPart();
                    itbag.tier = 0;
                    itbag.islock = true;
                    itbag.time_use = 0;
                    conn.p.item.add_item_bag3(itbag);
                    conn.p.item.char_inventory(5);
                    conn.p.item.char_inventory(7);
                    List<box_item_template> ids = new ArrayList<>();
                    ids.add(new box_item_template(iditem, (short) 1, (byte) 3));
                    Service.Show_open_box_notice_item(conn.p, "Bạn nhận được", ids);
                    Manager.gI().chatKTGprocess("Chúc mừng "+ conn.p.name + " đổi thành công " + itbag.name);
                    break;
                }
                //
                case 115: {
                    conn.p.id_remove_time_use = -1;
                    break;
                }
                case 70: {
                    Service.send_notice_box(conn, "Cần 20k ngọc!");
                    break;
                }
                case 126: {
                    conn.p.id_buffer_126 = -1;
                    conn.p.id_index_126 = -1;
                    break;
                }
                case 114: {
                    conn.p.id_wing_split = -1;
                    break;
                }
                case 113: {
                    conn.p.name_mem_clan_to_appoint = "";
                    break;
                }
            }
        } else {
            switch (type) {
                case -127: {
                    if (!conn.p.isOwner) {
                        return;
                    }
                    if (conn.p.get_ngoc() < 1) {
                        Service.send_notice_box(conn, "1 ngọc còn dell có thì làm ăn được gì");
                        return;
                    }
                    if (conn.p.level < 30) {
                        Service.send_notice_box(conn, "Yêu cầu level 30");
                        return;
                    }
                    if (conn.p.squire == null) {
                        Squire.create(conn.p);
                        conn.p.squire = new Squire(conn, conn.p.index);
                        conn.p.squire.load();
                        conn.p.update_ngoc(-1);
                        Service.send_notice_box(conn, "Nhận thành công đệ tử");
                        Squire.callSquire(conn);
                    }
                    break;
                }
                case -124: {
                    if (conn.p.squire != null && conn.p.isOwner) {
                        try (Connection connnect = SQL.gI().getConnection(); PreparedStatement ps = connnect.prepareStatement("DELETE FROM `squire` WHERE `id` = ?;")) {
                            ps.setInt(1, conn.p.squire.index);
                            ps.executeUpdate();
                            connnect.commit();
                        } catch (SQLException e) {
                            e.printStackTrace();
                        }
                        if (conn.p.isLiveSquire) {
                            Squire.squireLeaveMap(conn.p);
                        }
                        conn.p.isLiveSquire = false;
                        conn.p.squire = null;
                        Service.send_notice_box(conn, "Đã huỷ đệ tử");
                    } else {
                        Service.send_notice_box(conn, "Chưa có đệ tử");
                    }
                }
                case -122: {
                    // Đệ tử
                    if (!conn.p.isOwner) {
                        return;
                    }
                    if (conn.p.get_ngoc() > 5) {
                        if ((conn.p.item.total_item_by_id(7, 472) > 50 && conn.p.item.total_item_by_id(7, 473) > 50
                                && conn.p.item.total_item_by_id(7, 474) > 50 && conn.p.item.total_item_by_id(7, 475) > 50) || conn.ac_admin > 2) {
                            short[] id_ma_phap = new short[]{4578, 4579, 4581, 4583};
                            ItemTemplate3 temp3 = ItemTemplate3.item.get(id_ma_phap[Util.random(id_ma_phap.length)]);
                            Item3 it = new Item3();
                            it.id = temp3.getId();
                            it.name = temp3.getName();
                            it.clazz = temp3.getClazz();
                            it.type = temp3.getType();
                            it.level = temp3.getLevel();
                            it.icon = temp3.getIcon();
                            it.op = temp3.getOp();
                            it.op.add(new Option((byte) 61, 0));
                            it.color = 3;
                            it.islock = true;
                            it.part = temp3.getPart();
                            conn.p.item.add_item_bag3(it);
                            it.op.clear();
                            conn.p.item.remove(7, 472, 50);
                            conn.p.item.remove(7, 473, 50);
                            conn.p.item.remove(7, 474, 50);
                            conn.p.item.remove(7, 475, 50);
                            conn.p.item.char_inventory(3);
                            conn.p.item.char_inventory(4);
                            conn.p.item.char_inventory(7);
                            conn.p.update_ngoc(-5);

                            Service.send_notice_box(conn, "Ghép thành công");
                        } else {
                            Service.send_notice_box(conn, "Bạn cần có 50 mảnh (Mảnh sách đỏ 1, Mảnh sách đỏ 2," +
                                    " Mảnh sách đỏ 3, Mảnh sách đỏ 4)");
                        }
                    } else {
                        Service.send_notice_box(conn, "Không đủ ngọc");
                    }
                    break;
                }
                case -123: {
                    // Đệ tử
                    if (!conn.p.isOwner) {
                        return;
                    }
                    if (conn.p.get_ngoc() >= 10) {
                        if ((conn.p.item.total_item_by_id(7, 476) > 50 && conn.p.item.total_item_by_id(7, 477) > 50
                                && conn.p.item.total_item_by_id(7, 478) > 50 && conn.p.item.total_item_by_id(7, 479) > 50) || conn.ac_admin > 2) {
                            short[] id_vat_ly = new short[]{4577, 4580, 4582, 4584};
                            ItemTemplate3 temp3 = ItemTemplate3.item.get(id_vat_ly[Util.random(id_vat_ly.length)]);
                            Item3 it = new Item3();
                            it.id = temp3.getId();
                            it.name = temp3.getName();
                            it.clazz = temp3.getClazz();
                            it.type = temp3.getType();
                            it.level = temp3.getLevel();
                            it.icon = temp3.getIcon();
                            it.op = temp3.getOp();
                            it.op.add(new Option((byte) 61, 0));
                            it.color = 0;
                            it.islock = true;
                            it.part = temp3.getPart();
                            conn.p.item.add_item_bag3(it);
                            it.op.clear();
                            conn.p.item.remove(7, 477, 50);
                            conn.p.item.remove(7, 478, 50);
                            conn.p.item.remove(7, 479, 50);
                            conn.p.item.remove(7, 480, 50);
                            conn.p.item.char_inventory(3);
                            conn.p.item.char_inventory(4);
                            conn.p.item.char_inventory(7);
                            conn.p.update_ngoc(-10);

                            Service.send_notice_box(conn, "Ghép thành công");
                        } else {
                            Service.send_notice_box(conn, "Bạn cần có 50 mảnh (Mảnh sách xanh 1, Mảnh sách xanh 2," +
                                    " Mảnh sách xanh 3, Mảnh sách xanh 4)");
                        }
                    } else {
                        Service.send_notice_box(conn, "Không đủ ngọc");
                    }
                    break;
                }
                case -121: {
                    // Đệ tử
                    if (!conn.p.isOwner) {
                        return;
                    }
                    int level = conn.p.skill_110[conn.p.id_index_temp];
                    if (conn.p.skill_110[conn.p.id_index_temp] >= 10) {
                        conn.p.id_index_temp = -1;
                        Service.send_notice_box(conn, "Kỹ năng được nâng cấp tối đa");
                        return;
                    }
                    int id_book = -1;
                    if (conn.p.id_index_temp == 1) {
                        id_book = switch (conn.p.clazz) {
                            case 0 -> 4577;
                            case 1 -> 4580;
                            case 2 -> 4582;
                            case 3 -> 4583;
                            default -> id_book;
                        };
                    } else if (conn.p.id_index_temp == 0) {
                        id_book = switch (conn.p.clazz) {
                            case 0 -> 4578;
                            case 1 -> 4579;
                            case 2 -> 4581;
                            case 3 -> 4584;
                            default -> id_book;
                        };
                    }
                    if (conn.p.get_ngoc() < level * 5 + 10) {
                        conn.p.id_index_temp = -1;
                        Service.send_notice_box(conn, "Không đủ ngọc");
                        return;
                    }
                    if (conn.p.item.total_item_book_skill(id_book) >= (level + 1)) {
                        if (Util.nextInt(100) < 22 - level || level == 0) {
                            conn.p.skill_110[conn.p.id_index_temp] += 1;
                            Service.send_notice_box(conn, "Nâng cấp thành công");
                            conn.p.load_skill();
                            Service.send_skill(conn.p);
                        } else {
                            Service.send_notice_box(conn, "Thất bại rồi");
                        }
                        conn.p.item.remove_item_book(id_book, (level + 1));
                        conn.p.item.char_inventory(3);
                        conn.p.id_index_temp = -1;
                        conn.p.update_ngoc(-(level * 5 + 10));
                    } else {
                        Service.send_notice_box(conn, "Không đủ sách");
                    }
                    break;
                }
                case -120: {
                    // Đệ tử
                    if (!conn.p.isOwner) {
                        return;
                    }
                    int level = conn.p.skill_110[conn.p.id_index_temp];
                    if (conn.p.skill_110[conn.p.id_index_temp] >= 10) {
                        conn.p.id_index_temp = -1;
                        Service.send_notice_box(conn, "Kỹ năng được nâng cấp tối đa");
                        return;
                    }
                    int id_book = -1;
                    int type_book = -1;
                    if (conn.p.id_index_temp == 0) {
                        type_book = 0;
                        id_book = switch (conn.p.clazz) {
                            case 0 -> 4577;
                            case 1 -> 4580;
                            case 2 -> 4582;
                            case 3 -> 4583;
                            default -> id_book;
                        };
                    } else if (conn.p.id_index_temp == 1) {
                        type_book = 3;
                        id_book = switch (conn.p.clazz) {
                            case 0 -> 4578;
                            case 1 -> 4579;
                            case 2 -> 4581;
                            case 3 -> 4584;
                            default -> id_book;
                        };
                    }
                    if (conn.p.get_ngoc() < level * 5 + 10) {
                        conn.p.id_index_temp = -1;
                        Service.send_notice_box(conn, "Không đủ ngọc");
                        return;
                    }
                    if (conn.p.item.total_item_book(type_book, id_book) >= (level + 1) || conn.ac_admin > 2) {
                        if (Util.nextInt(100) < 20 - level || level == 0) {
                            conn.p.skill_110[conn.p.id_index_temp] += 1;
                            Service.send_notice_box(conn, "Nâng cấp thành công");
                            conn.p.load_skill();
                            Service.send_skill(conn.p);
                        } else {
                            Service.send_notice_box(conn, "Thất bại rồi");
                        }
                        conn.p.id_index_temp= -1;
                        conn.p.item.remove_item_book(id_book, (level + 1));
                        conn.p.item.char_inventory(3);
                        conn.p.update_ngoc(-(level * 5 + 10));
                    } else {
                        Service.send_notice_box(conn, "Không đủ sách");
                    }
                    break;
                }
                case 112: {
                    Wedding temp = Wedding.get_obj(conn.p.name);
                    if (temp.exp < Level.entrys.get(temp.it.tier).exp) {
                        Service.send_notice_box(conn, "chưa đủ 100% exp!");
                        return;
                    }
                    long vang_req = (3 * (temp.it.tier + 1)) * 5_000_000L;
                    int ngoc_req = (3 * (temp.it.tier + 1)) * 5000;
                    if (conn.p.get_vang() < vang_req) {
                        Service.send_notice_box(conn, "chưa đủ " + vang_req + " vàng!");
                        return;
                    }
                    if (conn.p.get_ngoc() < ngoc_req) {
                        Service.send_notice_box(conn, "chưa đủ " + ngoc_req + " ngọc!");
                        return;
                    }
                    conn.p.update_vang(-vang_req);
                    conn.p.update_ngoc(-ngoc_req);
                    conn.p.item.char_inventory(5);
                    boolean suc = 80 > Util.random(100);
                    if (suc) {
                        temp.exp -= Level.entrys.get(temp.it.tier).exp;
                        temp.it.tier++;
                        Service.send_notice_box(conn, "nâng cấp thành công lên +" + temp.it.tier);
                        conn.p.item.wear[23] = temp.it;
                        Service.send_wear(conn.p);
                        Service.send_char_main_in4(conn.p);
                        MapService.update_in4_2_other_inside(conn.p.map, conn.p);
                        //
                        Player p0 = Map.get_player_by_name(temp.name_1.equals(conn.p.name) ? temp.name_2 : temp.name_1);
                        if (p0 != null) {
                            p0.item.wear[23] = temp.it;
                            Service.send_wear(p0);
                            Service.send_char_main_in4(p0);
                            MapService.update_in4_2_other_inside(p0.map, p0);
                        }
                    } else {
                        Service.send_notice_box(conn, "nâng cấp thất bại!");
                    }
                    break;
                }
                case 111: {
                    Wedding temp = Wedding.get_obj(conn.p.name);
                    conn.p.item.wear[23] = null;
                    Service.send_wear(conn.p);
                    Service.send_char_main_in4(conn.p);
                    MapService.update_in4_2_other_inside(conn.p.map, conn.p);
                    Service.send_notice_box(conn, "Ly hôn thành công");
                    conn.p.it_wedding = null;
                    Player p0 = Map.get_player_by_name(temp.name_1.equals(conn.p.name) ? temp.name_2 : temp.name_1);
                    if (p0 != null) {
                        p0.item.wear[23] = null;
                        Service.send_wear(p0);
                        Service.send_char_main_in4(p0);
                        MapService.update_in4_2_other_inside(p0.map, p0);
                        Service.send_notice_box(p0.conn, conn.p.name + " đã rời xa bạn");
                        p0.it_wedding = null;
                    }
                    Wedding.remove_wed(temp);
                    break;
                }
                case 110: {
                    Player p0 = Map.get_player_by_name(conn.p.in4_wedding[1]);
                    Wedding.add_new(Integer.parseInt(conn.p.in4_wedding[0]), p0, conn.p);
                    conn.p.in4_wedding = null;
                    Service.send_notice_box(p0.conn, "chúc mừng " + conn.p.name + " trở thành bạn đời của bạn");
                    Service.send_notice_box(conn, "chúc mừng " + p0.name + " trở thành bạn đời của bạn");
                    break;
                }
                 
                case 97:{
                    conn.p.Store_Sell_ToPL="no name";
                    Service.send_box_input_text(conn, 20, "Bán riêng cho nhân vật", new String[]{"Tên nhân vật"});
                    break;
                }
                case 113: {
                    if (conn.p.name_mem_clan_to_appoint.isEmpty()) {
                        return;
                    }
                    if (conn.p.myclan != null && conn.p.myclan.mems.get(0).name.equals(conn.p.name)) {
                        boolean suc = false;
                        for (int i = 1; i < conn.p.myclan.mems.size(); i++) {
                            if (conn.p.myclan.mems.get(i).name.equals(conn.p.name_mem_clan_to_appoint)) {
                                Clan_mems temp = conn.p.myclan.mems.get(0);
                                //
                                conn.p.myclan.mems.get(i).mem_type = 127;
                                conn.p.myclan.mems.get(0).mem_type = 122;
                                //
                                conn.p.myclan.mems.set(0, conn.p.myclan.mems.get(i));
                                conn.p.myclan.mems.set(i, temp);

                                //
                                MapService.update_in4_2_other_inside(conn.p.map, conn.p);
                                MapService.send_in4_other_char(conn.p.map, conn.p, conn.p);
                                Service.send_char_main_in4(conn.p);

                                Player p0 = Map.get_player_by_name(conn.p.myclan.mems.get(0).name);
                                if (p0 != null) {
                                    MapService.update_in4_2_other_inside(p0.map, p0);
                                    MapService.send_in4_other_char(p0.map, p0, p0);
                                    Service.send_char_main_in4(p0);
                                }
                                //
                                suc = true;
                                break;
                            }
                        }
                        if (suc) {
                            Service.send_notice_box(conn, "Thành công!");
                        } else {
                            Service.send_notice_box(conn, "Tên không tồn tại");
                        }
                    } else {
                        Service.send_notice_box(conn, "Đã xảy ra lỗi");
                    }
                    break;
                }
                case 114: {
                    Item3 item = null;
                    int count = 0;
                    for (int i = 0; i < conn.p.item.bag3.length; i++) {
                        Item3 it = conn.p.item.bag3[i];
                        if (it != null && it.type == 7 && it.tier > 0) {
                            if (count == conn.p.id_wing_split) {
                                item = it;
                                break;
                            }
                            count++;
                        }
                    }
                    if (item != null) {

                        int quant1 = 40;
                        int quant2 = 10;
                        int quant3 = 50;
                        for (int i = 0; i < item.tier; i++) {
                            quant1 += GameSrc.wing_upgrade_material_long_khuc_xuong[i];
                            quant2 += GameSrc.wing_upgrade_material_kim_loai[i];
                            quant3 += GameSrc.wing_upgrade_material_da_cuong_hoa[i];
                            if ((i + 1) == 10 || (i + 1) == 20 || (i + 1) == 30) {
                                item.part--;
                            }
                        }
                        if (item.tier > 15) {
                            quant1 /= 2;
                            quant2 /= 2;
                            quant3 /= 2;
                        } else {
                            quant1 /= 3;
                            quant2 /= 3;
                            quant3 /= 3;
                        }
                        short[] id_ = new short[]{8, 9, 10, 11, 3, 0};
                        int[] quant_ = new int[]{quant1, quant1, quant1, quant1, quant2, quant3};
                        for (int i = 0; i < id_.length; i++) {
                            Item47 it = new Item47();
                            it.category = 7;
                            it.id = id_[i];
                            it.quantity = (short) quant_[i];
                            conn.p.item.add_item_bag47(7, it);
                        }
                        //
//                                                item = null;
                        count = 0;
                        for (int i = 0; i < conn.p.item.bag3.length; i++) {

                            Item3 it = conn.p.item.bag3[i];
                            if (it != null && it.type == 7 && it.tier > 0) {
                                if (count == conn.p.id_wing_split) {
                                    conn.p.item.bag3[i] = null;
                                    break;
                                }
                                count++;
                            }
                        }
                        conn.p.id_wing_split = -1;
//                                                for (int i = 0; i < item.op.size(); i++) {
//                                                if ((item.op.get(i).id > 26 || item.op.get(i).id < 23)
//							      && (item.op.get(i).id != 41 && item.op.get(i).id != 42)) {
//                                                    item.op.remove(i--);
//                                                }
//                                            }
                        //
                        conn.p.item.char_inventory(4);
                        conn.p.item.char_inventory(7);
                        conn.p.item.char_inventory(3);
                        Service.send_notice_box(conn, "Thành công");
                    } else {
                        Service.send_notice_box(conn, "Có lỗi xảy ra, hãy thử lại!");
                        conn.p.id_wing_split = -1;
                    }
                    break;
                }
                case 9: {
                    if(conn.p.map.isMapChienTruong()){
                        
                    }
                    else if(conn.p.map.isMapChiemThanh()){
                        ChiemThanhManager.ActionHoiSinh(conn.p.map, conn.p);
                    }
                    else {
                        if (conn.p.get_ngoc() >= 5) {
                            conn.p.isDie = false;
                            conn.p.hp = conn.p.body.get_HpMax();
                            conn.p.mp = conn.p.body.get_MpMax();
                            conn.p.update_ngoc(-5);
                            conn.p.item.char_inventory(5);
                            Service.send_char_main_in4(conn.p);
                            // chest in4
                            Service.send_combo(conn);
                            Service.usepotion(conn.p, 0, conn.p.body.get_HpMax());
                            Service.usepotion(conn.p, 1, conn.p.body.get_MpMax());
                        } else {
                            Service.send_notice_box(conn, "Không đủ ngọc để thực hiện");
                        }
                    }
                    break;
                }
                case 86: {
                    Manager.gI().vxmm.send_in4(conn.p);
                    break;
                }
                case 87: {
                    Manager.gI().vxkc.send_in4(conn.p);
                    break;
                }
                case 94: {
                    GameSrc.ChangeCS_Medal(conn, 94);
                    break;
                }
                case 98: {
                    GameSrc.ChangeCS_Medal(conn, 98);
                    break;
                }

                case 115: {
                    if (conn.p.id_remove_time_use != -1) {
                        Item3 it = conn.p.item.bag3[conn.p.id_remove_time_use];
                        if (it != null && it.time_use > 0) {
                            int ngoc_ = conn.p.get_ngoc();
                            if (ngoc_ > 4) {
                                long price = it.time_use - System.currentTimeMillis();
                                price /= 30_600_000;
                                price = (price > 4) ? (price + 1) : 5;
                                boolean ch = false;
                                if (ngoc_ >= price) {
                                    ch = true;
                                } else {
                                    price = ngoc_;
                                }
                                it.time_use -= (price * 30_600_000);
                                conn.p.update_ngoc(-price);
                                conn.p.item.char_inventory(4);
                                conn.p.item.char_inventory(7);
                                conn.p.item.char_inventory(3);
                                conn.p.id_remove_time_use = -1;
                                if (ch) {
                                    Service.send_notice_box(conn, "Nhận được " + it.name + " +" + it.tier + "!");
                                }
                            } else {
                                Service.send_notice_box(conn, "Tối thiểu 5 ngọc!");
                            }
                        }
                    }
                    break;
                }
                case 116: {
                    if (conn.p.myclan != null && conn.p.myclan.mems.get(0).name.equals(conn.p.name)) {
                        conn.p.myclan.remove_all_mem();
                        conn.p.myclan.remove_mem(conn.p.name);
                        conn.p.myclan = null;
                        MapService.update_in4_2_other_inside(conn.p.map, conn.p);
                        MapService.send_in4_other_char(conn.p.map, conn.p, conn.p);
                        Service.send_char_main_in4(conn.p);
                        Service.send_notice_box(conn, "Hủy bang thành công");
                    }
                    break;
                }
                case 117: {
                    if (conn.p.myclan != null) {
                        conn.p.myclan.remove_mem(conn.p.name);
                        conn.p.myclan = null;
                        MapService.update_in4_2_other_inside(conn.p.map, conn.p);
                        MapService.send_in4_other_char(conn.p.map, conn.p, conn.p);
                        Service.send_char_main_in4(conn.p);
                        Service.send_notice_box(conn, "Rời bang thành công");
                    }
                    break;
                }
                case 118: {
                    if (conn.p.myclan.mems.get(0).name.equals(conn.p.name)) {
                        if ((Clan.vang_upgrade[1] * conn.p.myclan.level) > conn.p.myclan.get_vang()) {
                            Service.send_notice_box(conn, "Không đủ vàng để thực hiện");
                            return;
                        }
                        if ((Clan.ngoc_upgrade[1] * conn.p.myclan.level) > conn.p.myclan.get_ngoc()) {
                            Service.send_notice_box(conn, "Không đủ ngọc để thực hiện");
                            return;
                        }
                        conn.p.myclan.update_vang(-Clan.vang_upgrade[1] * conn.p.myclan.level);
                        conn.p.myclan.update_ngoc(-Clan.ngoc_upgrade[1] * conn.p.myclan.level);
                        conn.p.myclan.level++;
                        conn.p.myclan.exp = 0;
                        if (conn.p.myclan.max_mem < 45 && conn.p.myclan.level % 5 == 0) {
                            conn.p.myclan.max_mem += 5;
                        }
                        Service.send_notice_box(conn, "Nâng bang lên cấp " + conn.p.myclan.level + " thành công");
                    }
                    break;
                }
                case 119: {
                    if(conn.p.point_active[0] !=10)
                    {
                        if(conn.p.get_ngoc() < 30)
                        {
                            Service.send_notice_box(conn, "Bạn không đủ ngọc để tham gia!");
                            return;
                        }
                        conn.p.update_ngoc(-30);
                        conn.p.item.char_chest(5);
                    }
                    Dungeon d = DungeonManager.get_list(conn.p.name);
                    if (d == null) {
                        try {
                            d = new Dungeon();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        if(conn.p.point_active[0] <=0)
                            Service.send_notice_box(conn, "Hãy quay lại vào ngày hôm sau!");
                        else if (d != null) {
                            conn.p.point_active[0]--;
                            //
                            d.name_party = conn.p.name;
                            d.setMode(0);
                            //
                            MapService.leave(conn.p.map, conn.p);
                            conn.p.map = d.template;
                            conn.p.x = 584;
                            conn.p.y = 672;
                            MapService.enter(conn.p.map, conn.p);
                            d.send_map_data(conn.p);
                            //
                            DungeonManager.add_list(d);
                        } else {
                            Service.send_notice_box(conn, "Lỗi, hãy thử lại sau!");
                        }
                    } else {
                        MapService.leave(conn.p.map, conn.p);
                        conn.p.map = d.template;
                        MapService.enter(conn.p.map, conn.p);
                        d.send_map_data(conn.p);
                        d.send_mob_move_when_exit(conn.p);
                    }
                    break;
                }
                case 70: {
                    if (conn.p.get_ngoc() < 20000) {
                        Service.send_notice_box(conn, "20k ngọc còn không có thì không xứng đáng làm anh hùng!");
                        return;
                    }
                    Service.send_box_input_text(conn, 23, "Bang hội", new String[]{"Tên (4-20 ký tự) :", "Tên viết tắt (3 ký tự) :"});
//                    Message m12 = new Message(-53);
//                    m12.writer().writeShort(0);
//                    String[] txt = new String[]{"Tên (4-20 ký tự) :", "Tên viết tắt (3 ký tự) :"};
//                    m12.writer().writeByte(txt.length);
//                    for (String string : txt) {
//                        m12.writer().writeUTF(string);
//                    }
//                    m12.writer().writeUTF("Đăng ký bang");
//                    m12.writer().writeUTF("Bang hội");
//                    conn.addmsg(m12);
//                    m12.cleanup();
                    break;
                }
//                case 121: {
//                    Service.send_notice_box(conn, "Chức năng không còn tồn tại.");
//                    if (conn.p.get_ngoc() < 1000) {
//                        Service.send_notice_box(conn, "Không đủ 1000 ngọc!");
//                        return;
//                    }
//                    conn.p.update_ngoc(-1000);
//                    conn.p.item.char_inventory(5);
//                    EffTemplate ef = conn.p.get_eff(-126);
//                    if (ef != null) {
//                        long time_extra = (ef.time - System.currentTimeMillis()) + (1000 * 60 * 60 * 2);
//                        if (time_extra > (1000 * 60 * 60 * 24 * 3)) {
//                            time_extra = 1000 * 60 * 60 * 24 * 3;
//                        }
//                        conn.p.add_eff(-126, 99, (int) time_extra);
//                    } else {
//                        conn.p.add_eff(-126, 99, (1000 * 60 * 60 * 2));
//                    }
//                    Service.send_notice_box(conn, "Đăng ký thành công");
//                    break;
//                }
                case 122: { // chuyển hoá
//                    if((conn.p.item.bag3[conn.p.item_replace].id >= 4587 && conn.p.item.bag3[conn.p.item_replace].id<= 4590) ||
//                            (conn.p.item.bag3[conn.p.item_replace2].id >= 4587 && conn.p.item.bag3[conn.p.item_replace2].id<= 4590))
//                    {
//                        Service.send_notice_box(conn, "Trang bị không phù hợp!");
//                        return;
//                    }
                    int fee = 50 * conn.p.item.bag3[conn.p.item_replace].tier;
                    if (conn.p.get_ngoc() < fee) {
                        Service.send_notice_box(conn, "Không đủ " + fee + " ngọc!");
                        return;
                    }
                    conn.p.item.bag3[conn.p.item_replace2].tier = conn.p.item.bag3[conn.p.item_replace].tier;
                    conn.p.item.bag3[conn.p.item_replace].tier = 0;
//                    if (conn.p.item.bag3[conn.p.item_replace2].type == 5
//                            && conn.p.item.bag3[conn.p.item_replace2].tier >= 9) {
//                        for (Option op_ : conn.p.item.bag3[conn.p.item_replace2].op) {
//                            if (op_.id == 37 && op_.getParam(conn.p.item.bag3[conn.p.item_replace2].tier) > 1) {
//                                op_.setParam(op_.getParam(conn.p.item.bag3[conn.p.item_replace2].tier));
//                            }
//                        }
//                    }
                    conn.p.update_ngoc(-fee);
                    conn.p.item.char_inventory(3);
                    Service.send_notice_box(conn, "Chuyển hóa thành công!");
                    //
                    Message m3 = new Message(73);
                    m3.writer().writeByte(0);
                    m3.writer().writeShort(conn.p.item_replace2);
                    m3.writer().writeByte(0);
                    conn.addmsg(m3);
                    m3.cleanup();
                    //
                    m3 = new Message(73);
                    m3.writer().writeByte(0);
                    m3.writer().writeShort(conn.p.item_replace);
                    m3.writer().writeByte(1);
                    conn.addmsg(m3);
                    m3.cleanup();
                    //
                    break;
                }
                case 123: {
                    break;
                }
                case 124: {
                    conn.p.rest_skill_point();
                    conn.p.item.remove(4, 7, 1);
                    conn.p.item.char_inventory(4);
                    Service.send_notice_box(conn, "Tẩy điểm kỹ năng thành công");
                    break;
                }
                case 125: {
                    conn.p.rest_potential_point();
                    conn.p.item.remove(4, 6, 1);
                    conn.p.item.char_inventory(4);
                    Service.send_notice_box(conn, "Tẩy điểm tiềm năng thành công");
                    break;
                }
                case 126: {
                    if (conn.p.id_buffer_126 != -1) {
                        Item3 temp3 = conn.p.item.bag3[conn.p.id_buffer_126];
                        temp3.islock = true;
                        switch (temp3.type) {
                            case 0: // coat
                            case 1: // pant
                            case 2: // crown
                            case 3: // grove
                            case 4: // ring
                            case 5: // chain
                            case 6: // shoes
                            case 7: // wing
                            case 15:
                            case 8:
                            case 9:
                            case 10:
                            case 16:
                            case 21:
                            case 22:
                            case 23:
                            case 24:
                            case 25:
                            case 26:
                            case 11: { // weapon
                                conn.p.player_wear(conn, temp3, conn.p.id_buffer_126, conn.p.id_index_126);
                                break;
                            }
                            default: {
                                Service.send_notice_nobox_white(conn, "Ấn 2 lần mới có thể sử dụng");
                                break;
                            }
                        }
                    }
                    conn.p.id_buffer_126 = -1;
                    conn.p.id_index_126 = -1;
                    break;
                }
                case 88:{
                    if (conn.ac_admin < 10) {
                        Service.send_notice_box(conn, "Bạn chưa đủ quyền để thực hiện!");
                        return;
                    }
                    ServerManager.gI().close();
                    System.out.println("Close server is processing....");
                    new Thread(new Runnable() {
                        @Override
                        public void run() {
                            SaveData.process();
                            for (int k = Session.client_entrys.size() - 1; k >= 0; k--) {

                                try {
                                    Session.client_entrys.get(k).p = null;
                                    Session.client_entrys.get(k).close();
                                } catch (Exception e) {
                                    e.printStackTrace();
                                }
                            }
                            Manager.gI().close();
                        }
                    }).start();
                    break;
                }
            }
        }
    }
}
