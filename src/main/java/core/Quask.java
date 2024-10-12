package core;

import io.Session;
import template.Item3;
import template.ItemTemplate3;
import template.box_item_template;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Quask {
    //<editor-fold defaultstate="collapsed" desc="sk hồn gió...">
    public static void quask_hon_gio (Session conn, byte index) throws IOException {
        switch (index) {
            case 0: {
                if (conn.p.item.get_bag_able() <= 1) {
                    Service.send_notice_box(conn, "Hành trang đầy");
                    return;
                }
                List<box_item_template> ids = new ArrayList<>();
                List<Integer> duclo = new ArrayList<>(java.util.Arrays.asList(33, 44, 45));
                List<Integer> danangcap = new ArrayList<>(java.util.Arrays.asList(471, 349));
                List<Integer> thucuoi = new ArrayList<>(java.util.Arrays.asList(281,251,301,269,275,299,279,271,246,323));
                for (int i = 0; i < 3; i++) {
                    int ran = Util.random(101);
                    if (ran > 100) { // đá nâng cấp
                        short id = Util.random(danangcap, new ArrayList<>()).shortValue();
                        short quant = 1;
                        ids.add(new box_item_template(id, quant, (byte) 7));
                        conn.p.item.add_item_bag47(id, quant, (byte) 7);
                    } else if (ran > 90 && ran <= 93) { // nlmd
                        short id = (short) Util.random(46, 346);
                        short quant = 1;
                        ids.add(new box_item_template(id, quant, (byte) 7));
                        conn.p.item.add_item_bag47(id, quant, (byte) 7);
                    } else if (ran > 85 && ran < 90) { // đục
                        short id = Util.random(duclo, new ArrayList<>()).shortValue();
                        short quant = 1;
                        ids.add(new box_item_template(id, quant, (byte) 7));
                        conn.p.item.add_item_bag47(id, quant, (byte) 7);
                    } else if (ran > 60 && ran < 80) { // vé mở ly
                        short id = 52;
                        short quant = (short) Util.random(1, 10);
                        ids.add(new box_item_template(id, quant, (byte) 4));
                        conn.p.item.add_item_bag47(id, quant, (byte) 4);
                    } else if (ran > 53 && ran < 55) { // thú cưỡi
                        short id = Util.random(thucuoi, new ArrayList<>()).shortValue();;
                        short quant = 1;
                        ids.add(new box_item_template(id, quant, (byte) 4));
                        conn.p.item.add_item_bag47(id, quant, (byte) 4);
                    } else if (ran > 20 && ran < 35) { // sách nâng skill
                        short id = (short) Util.random(472,480);
                        short quant = (short) Util.random(1,5);
                        ids.add(new box_item_template(id, quant, (byte) 7));
                        conn.p.item.add_item_bag47(id, quant, (byte) 7);
                    } else if (ran > 10 && ran < 20) { // hồ quang
                        short id = (short) Util.random(472,480);
                        short quant = (short) Util.random(1,5);
                        ids.add(new box_item_template(id, quant, (byte) 7));
                        conn.p.item.add_item_bag47(id, quant, (byte) 7);
                    } else {
                        Service.send_notice_nobox_white(conn, "Đen vl. Bạn dell đc gì");
                    }
                }
                conn.p.sk_hongio += 1;
                Service.Show_open_box_notice_item(conn.p, "Bạn nhận được", ids);
                break;
            }
            case 1: {
                if (conn.p.item.get_bag_able() <= 1) {
                    Service.send_notice_box(conn, "Hành trang đầy");
                    return;
                }
                List<box_item_template> ids = new ArrayList<>();
                List<Integer> duclo = new ArrayList<>(java.util.Arrays.asList(33, 44, 45));
                List<Integer> thucuoi = new ArrayList<>(java.util.Arrays.asList(281,251,301,269,275,299,279,271,246,323));
                List<Integer> ngockham = new ArrayList<>(java.util.Arrays.asList(354, 359, 364, 369, 374, 379));
                List<Integer> danangcap = new ArrayList<>(java.util.Arrays.asList(471, 350));
                List<Integer> nlmdtim = new ArrayList<>(java.util.Arrays.asList(
                        136, 137, 138, 139, 140, 141,142,143,144,145,
                        236, 237, 238, 239, 240, 241,242,243,244,245,
                        336, 337, 338, 339, 340, 341,342,343,344,345));
                for (int i = 0; i < 3; i++) {
                    int ran = Util.random(101);
                    if ( ran > 101) { // sách 110
                        short iditem =(short) Util.random(4577, 4585);
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
                        itbag.islock = false;
                        itbag.time_use = 0;
                        conn.p.item.add_item_bag3(itbag);
                        conn.p.item.char_inventory(5);
                        ids.add(new box_item_template(iditem, (short) 1, (byte) 3));
                    } else if (ran > 95 && ran < 97) { // rương boss phe
                        short id = 273;
                        short quant = 1;
                        ids.add(new box_item_template(id, quant, (byte) 4));
                        conn.p.item.add_item_bag47(id, quant, (byte) 4);
                    } else if (ran > 93 && ran < 95) { // nlmd
                        short id = Util.random(nlmdtim, new ArrayList<>()).shortValue();
                        short quant = 1;
                        ids.add(new box_item_template(id, quant, (byte) 7));
                        conn.p.item.add_item_bag47(id, quant, (byte) 7);
                    } else if (ran > 85 && ran < 88) {// ngọc khảm
                        short id = Util.random(ngockham, new ArrayList<>()).shortValue();
                        short quant = 1;
                        ids.add(new box_item_template(id, quant, (byte) 7));
                        conn.p.item.add_item_bag47(id, quant, (byte) 7);
                    } else if (ran > 80 && ran < 84) { // đá nâng cấp
                        short id = Util.random(danangcap, new ArrayList<>()).shortValue();
                        short quant = 1;
                        ids.add(new box_item_template(id, quant, (byte) 7));
                        conn.p.item.add_item_bag47(id, quant, (byte) 7);
                    } else if (ran > 70 && ran < 75) { // đục
                        short id = Util.random(duclo, new ArrayList<>()).shortValue();
                        short quant = 1;
                        ids.add(new box_item_template(id, quant, (byte) 7));
                        conn.p.item.add_item_bag47(id, quant, (byte) 7);
                    } else if (ran > 60 && ran < 65) { // rương chiến công
                        short id = 274;
                        short quant = 1;
                        ids.add(new box_item_template(id, quant, (byte) 4));
                        conn.p.item.add_item_bag47(id, quant, (byte) 4);
                    } else if (ran > 50 && ran < 55) { // vé mở ly
                        short id = 52;
                        short quant = (short) Util.random(1, 10);
                        ids.add(new box_item_template(id, quant, (byte) 4));
                        conn.p.item.add_item_bag47(id, quant, (byte) 4);
                    } else if (ran > 40 && ran < 45) { // thú cưỡi
                        short id = Util.random(thucuoi, new ArrayList<>()).shortValue();;
                        short quant = 1;
                        ids.add(new box_item_template(id, quant, (byte) 4));
                        conn.p.item.add_item_bag47(id, quant, (byte) 4);
                    } else if (ran > 20 && ran < 35) { // sách nâng skill
                        short id = (short) Util.random(472,480);
                        short quant = (short) Util.random(1,5);
                        ids.add(new box_item_template(id, quant, (byte) 7));
                        conn.p.item.add_item_bag47(id, quant, (byte) 7);
                    } else if (ran > 10 && ran < 20) { // hồ quang
                        short id = (short) Util.random(472,480);
                        short quant = (short) Util.random(1,5);
                        ids.add(new box_item_template(id, quant, (byte) 7));
                        conn.p.item.add_item_bag47(id, quant, (byte) 7);
                    } else {
                        Service.send_notice_nobox_white(conn, "Đen vl bạn dell đc gì");
                    }
                }
                conn.p.sk_hongio += 3;
                Service.Show_open_box_notice_item(conn.p, "Bạn nhận được", ids);
                break;
            }
            case 2: {
                if (conn.p.item.get_bag_able() <= 1) {
                    Service.send_notice_box(conn, "Hành trang đầy");
                    return;
                }
                List<box_item_template> ids = new ArrayList<>();
                List<Integer> duclo = new ArrayList<>(java.util.Arrays.asList(33, 44, 45));
                List<Integer> item3 = new ArrayList<>(java.util.Arrays.asList(4732,4733,4710,4730,4731));
                List<Integer> thucuoi = new ArrayList<>(java.util.Arrays.asList(281,251,301,269,275,299,279,271,246,323));
                List<Integer> ngockham = new ArrayList<>(java.util.Arrays.asList(354, 355, 356, 359, 360, 361, 364, 365, 366, 369, 370, 371, 374, 375, 376, 379, 380, 381));
                List<Integer> danangcap = new ArrayList<>(java.util.Arrays.asList(471, 351));
                List<Integer> nlmdtim = new ArrayList<>(java.util.Arrays.asList(
                        136, 137, 138, 139, 140, 141,142,143,144,145,
                        236, 237, 238, 239, 240, 241,242,243,244,245,
                        336, 337, 338, 339, 340, 341,342,343,344,345));

                for (int i = 0; i < 3; i++) {
                    int ran = Util.random(101);
                    if (ran >= 100.9999) {// trang bị
                        short iditem = Util.random(item3, new ArrayList<>()).shortValue();;
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
                        itbag.islock = false;
                        itbag.time_use = 0;
                        conn.p.item.add_item_bag3(itbag);
                        conn.p.item.char_inventory(5);
                        ids.add(new box_item_template(iditem, (short) 1, (byte) 3));
                    } else if (ran >= 99 && ran < 100) { // sách 110
                        short iditem =(short) Util.random(4577, 4585);
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
                        itbag.islock = false;
                        itbag.time_use = 0;
                        conn.p.item.add_item_bag3(itbag);
                        conn.p.item.char_inventory(5);
                        ids.add(new box_item_template(iditem, (short) 1, (byte) 3));
                    } else if (ran > 90 && ran < 94) { // rương boss phe
                        short id = 273;
                        short quant = 1;
                        ids.add(new box_item_template(id, quant, (byte) 4));
                        conn.p.item.add_item_bag47(id, quant, (byte) 4);
                    } else if (ran > 85 && ran < 88) { // nlmd
                        short id = Util.random(nlmdtim, new ArrayList<>()).shortValue();
                        short quant = 1;
                        ids.add(new box_item_template(id, quant, (byte) 7));
                    } else if (ran > 80 && ran < 82) { // vp buff
                        short id = (short) Util.random(328,334);
                        short quant = 1;
                        ids.add(new box_item_template(id, quant, (byte) 4));
                        conn.p.item.add_item_bag47(id, quant, (byte) 4);
                    } else if (ran > 77 && ran < 80) { // đồng money
                        short id = 494;
                        short quant = 1;
                        ids.add(new box_item_template(id, quant, (byte) 7));
                        conn.p.item.add_item_bag47(id, quant, (byte) 7);
                    } else if (ran > 70 && ran < 75) {// ngọc khảm
                        short id = Util.random(ngockham, new ArrayList<>()).shortValue();
                        short quant = 1;
                        ids.add(new box_item_template(id, quant, (byte) 7));
                        conn.p.item.add_item_bag47(id, quant, (byte) 7);
                    } else if (ran > 64 && ran < 68) { // đá nâng cấp
                        short id = Util.random(danangcap, new ArrayList<>()).shortValue();
                        short quant = 1;
                        ids.add(new box_item_template(id, quant, (byte) 7));
                        conn.p.item.add_item_bag47(id, quant, (byte) 7);
                        conn.p.item.add_item_bag47(id, quant, (byte) 7);
                    } else if (ran > 52 && ran < 64) { // đục
                        short id = Util.random(duclo, new ArrayList<>()).shortValue();
                        short quant = 1;
                        ids.add(new box_item_template(id, quant, (byte) 7));
                        conn.p.item.add_item_bag47(id, quant, (byte) 7);
                    } else if (ran > 40 && ran < 50) { // rương chiến công
                        short id = 274;
                        short quant = 1;
                        ids.add(new box_item_template(id, quant, (byte) 4));
                        conn.p.item.add_item_bag47(id, quant, (byte) 4);
                    } else if (ran > 30 && ran < 40) { // vé mở ly
                        short id = 52;
                        short quant = (short) Util.random(1, 10);
                        ids.add(new box_item_template(id, quant, (byte) 4));
                        conn.p.item.add_item_bag47(id, quant, (byte) 4);
                    } else if (ran > 20 && ran < 30) { // thú cưỡi
                        short id = Util.random(thucuoi, new ArrayList<>()).shortValue();;
                        short quant = 1;
                        ids.add(new box_item_template(id, quant, (byte) 4));
                        conn.p.item.add_item_bag47(id, quant, (byte) 4);
                    } else if (ran > 10 && ran < 20) { // sách nâng skill
                        short id = (short) Util.random(472,480);
                        short quant = (short) Util.random(1,5);
                        ids.add(new box_item_template(id, quant, (byte) 7));
                        conn.p.item.add_item_bag47(id, quant, (byte) 7);
                    } else if (ran > 1 && ran < 10) { // hồ quang
                        short id = (short) Util.random(472,480);
                        short quant = (short) Util.random(1,5);
                        ids.add(new box_item_template(id, quant, (byte) 7));
                        conn.p.item.add_item_bag47(id, quant, (byte) 7);
                    } else {
                        Service.send_notice_nobox_white(conn, "Đen vl bạn dell đc gì");
                    }
                }
                conn.p.sk_hongio += 5;
                Service.Show_open_box_notice_item(conn.p, "Bạn nhận được", ids);
                break;
            }
        }
    }
    //</editor-fold>
    //<editor-fold defaultstate="collapsed" desc="sk mới...">
    public static void qua_sk_moi(Session conn, byte index) throws IOException {
        switch (index){
            case 0: {
                try {
                    if (conn.p.item.get_bag_able() <= 5) {
                        Service.send_notice_box(conn, "Hành trang đầy");
                        return;
                    }
                    List<box_item_template> ids = new ArrayList<>();
                    List<Integer> item3 = new ArrayList<>(java.util.Arrays.asList(4718, 4719));
                    List<Integer> duclo = new ArrayList<>(java.util.Arrays.asList(33, 44, 45));
                    List<Integer> ngockham = new ArrayList<>(java.util.Arrays.asList(354, 355, 356, 359, 360, 361, 364, 365, 366, 369, 370, 371, 374, 375, 376, 379, 380, 381));
                    for (int i = 0; i < 3; i++) {
                        int ran = Util.random(101);
                        if (ran > 100.999999) { // sách 110
                            short idsach = Util.random(item3, new ArrayList<>()).shortValue();
                            ids.add(new box_item_template(idsach, (short) 1, (byte) 3));
                            conn.p.item.add_item_bag3_default(idsach, 0, false);
                        } else if (ran > 100) { // sách 110
                            short idsach = (short) Util.random(4577, 4585);
                            ids.add(new box_item_template(idsach, (short) 1, (byte) 3));
                            conn.p.item.add_item_bag3_default(idsach, 0, false);
                        } else if (ran > 95 && ran <= 99) { // nlmd
                            short id = (short) Util.random(46, 346);
                            short quant = 1;
                            ids.add(new box_item_template(id, quant, (byte) 7));
                            conn.p.item.add_item_bag47(id, quant, (byte) 7);
                        } else if (ran > 90 && ran <= 95) { // nltt
                            short id = (short) Util.random(417, 464);
                            short quant = 1;
                            ids.add(new box_item_template(id, quant, (byte) 7));
                            conn.p.item.add_item_bag47(id, quant, (byte) 7);
                        } else if (ran > 85 && ran < 88) { // đục
                            short id = Util.random(duclo, new ArrayList<>()).shortValue();
                            short quant = 1;
                            ids.add(new box_item_template(id, quant, (byte) 7));
                            conn.p.item.add_item_bag47(id, quant, (byte) 7);
                        } else if (ran > 70 && ran < 80) { // vé đi buôn
                            short id = 147;
                            short quant = (short) Util.random(0, 5);
                            ids.add(new box_item_template(id, quant, (byte) 4));
                            conn.p.item.add_item_bag47(id, quant, (byte) 4);
                        } else if (ran > 60 && ran < 70) { // vé mở ly
                            short id = 52;
                            short quant = (short) Util.random(1, 10);
                            ids.add(new box_item_template(id, quant, (byte) 4));
                            conn.p.item.add_item_bag47(id, quant, (byte) 4);
                        } else if (ran > 40 && ran < 55) { // ngọc khảm
                            short id = Util.random(ngockham, new ArrayList<>()).shortValue();
                            short quant = 1;
                            ids.add(new box_item_template(id, quant, (byte) 7));
                            conn.p.item.add_item_bag47(id, quant, (byte) 7);
                        } else if (ran > 20 && ran < 35) { // sách nâng skill
                            short id = (short) Util.random(472, 480);
                            short quant = (short) Util.random(1, 5);
                            ids.add(new box_item_template(id, quant, (byte) 7));
                            conn.p.item.add_item_bag47(id, quant, (byte) 7);
                        } else if (ran > 10 && ran < 20) { // hồ quang
                            short id = (short) Util.random(472, 480);
                            short quant = (short) Util.random(1, 5);
                            ids.add(new box_item_template(id, quant, (byte) 7));
                            conn.p.item.add_item_bag47(id, quant, (byte) 7);
                        } else {
                            Service.send_notice_nobox_white(conn, "Đen vl. Bạn dell đc gì");
                        }
                    }
                    conn.p.sk_hongio += 1;
                    Service.Show_open_box_notice_item(conn.p, "Bạn nhận được", ids);
                }catch (Exception e){
                    e.printStackTrace();
                }
                break;
            }
            case 1: {
                if (conn.p.item.get_bag_able() <= 5) {
                    Service.send_notice_box(conn, "Hành trang đầy");
                    return;
                }
                List<box_item_template> ids = new ArrayList<>();
                List<Integer> trung_xin = new ArrayList<>(java.util.Arrays.asList(3269, 4617, 4626, 4699, 4708));
                List<Integer> trung_vua = new ArrayList<>(java.util.Arrays.asList(3616, 4622, 4631, 4788));
                List<Integer> trung_phe = new ArrayList<>(java.util.Arrays.asList(2939, 2943, 2944, 4761, 4762, 4768));
                List<Integer> thucuoi = new ArrayList<>(java.util.Arrays.asList(317, 316, 314, 313, 296, 268));
                for (int i = 0; i < 2; i++) {
                    int ran = Util.random(101);
                    if (ran > 100.9999) { // trứng xịn
                        short id = Util.random(trung_xin, new ArrayList<>()).shortValue();
                        ids.add(new box_item_template(id, (short) 1, (byte) 3));
                        conn.p.item.add_item_bag3_default(id, 0, false);
                    } else if (ran > 94 && ran < 100) { // trứng vừa
                        short id = Util.random(trung_vua, new ArrayList<>()).shortValue();;
                        ids.add(new box_item_template(id, (short) 1, (byte) 3));
                        conn.p.item.add_item_bag3_default(id, 0, false);
                    } else if (ran > 60 && ran < 90) { // trứng phế
                        short id = Util.random(trung_phe, new ArrayList<>()).shortValue();;
                        ids.add(new box_item_template(id, (short) 1, (byte) 3));
                        conn.p.item.add_item_bag3_default(id, 0, false);
                    } else if (ran > 30 && ran < 60) { // thú cưỡi vv
                        short id = Util.random(thucuoi, new ArrayList<>()).shortValue();
                        short quant = 1;
                        ids.add(new box_item_template(id, quant, (byte) 4));
                        conn.p.item.add_item_bag47(id, quant, (byte) 4);
                    } else if (ran > 2 && ran < 30) { // vé đi buôn
                        short id = 147;
                        short quant = (short) Util.random(10,20);
                        ids.add(new box_item_template(id, quant, (byte) 4));
                        conn.p.item.add_item_bag47(id, quant, (byte) 4);
                    } else {
                        Service.send_notice_nobox_white(conn, "Đen vl. Bạn dell đc gì");
                    }
                }
                conn.p.sk_hongio += 5;
                Service.Show_open_box_notice_item(conn.p, "Bạn nhận được", ids);
                break;
            }
        }
    }
    //</editor-fold>
}
