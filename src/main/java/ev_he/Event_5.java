/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ev_he;

import client.Player;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import map.Map;
import map.Mob_in_map;
import template.MainObject;
import map.LeaveItemMap;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;

/**
 *
 * @author Mr.Chip
 */
public class Event_5 {
    private static String name_event = "Event Trung thu"; // sự kiện trung thu
    
    public static final List<BXH_DoiQua> list_trungthu = new ArrayList<>();
    
//    public static void LeaveItemMap(Map map, MainObject focus, MainObject objAtk)throws IOException{
//        if(!objAtk.isPlayer())return;
//
//        Player p = (Player)objAtk;
//        LeaveItemMap.leave_item_by_type4(map, (short)306,p,focus.index);
//    }
    
    public static class BXH_DoiQua {

        public String name;
        public int quant;
        public long time;

        public BXH_DoiQua(String name2, int integer, long t) {
            name = name2;
            quant = integer;
            time = t;
        }
    }
    public static void add_DoiQua(String name, int quant) {
        synchronized(list_trungthu){
            for (int i = 0; i < list_trungthu.size(); i++) {
                if (list_trungthu.get(i).name.equals(name)) {
                    list_trungthu.get(i).quant += quant;
                    list_trungthu.get(i).time = System.currentTimeMillis();
                    return;
                }
            }
            list_trungthu.add(new BXH_DoiQua(name, quant, System.currentTimeMillis()));
        }
    }
    public static void LoadDB(JSONObject jsob){
        synchronized(list_trungthu){
            list_trungthu.clear();
            long t_ = System.currentTimeMillis();
            JSONArray jsar_1 = (JSONArray) JSONValue.parse(jsob.get("list_trungthu").toString());
            for (int i = 0; i < jsar_1.size(); i++) {
                JSONArray jsar_2 = (JSONArray) JSONValue.parse(jsar_1.get(i).toString());
                list_trungthu.add(new BXH_DoiQua(jsar_2.get(0).toString(), Integer.parseInt(jsar_2.get(1).toString()), t_));
            }
            jsar_1.clear();
        }
    }
    public static JSONObject SaveData(){
        synchronized(list_trungthu){
            JSONArray jsar_1 = new JSONArray();
            for (int i = 0; i < list_trungthu.size(); i++) {
                JSONArray jsar_2 = new JSONArray();
                jsar_2.add(list_trungthu.get(i).name);
                jsar_2.add(list_trungthu.get(i).quant);
                jsar_1.add(jsar_2);
            }
            //
            JSONObject jsob = new JSONObject();
            jsob.put("list_trungthu", jsar_1);
            return jsob;
        }
    }
    public static void sort_bxh() {
        synchronized(list_trungthu){
            Collections.sort(list_trungthu, new Comparator<BXH_DoiQua>() {
                @Override
                public int compare(BXH_DoiQua o1, BXH_DoiQua o2) {
                    int compare = (o1.quant == o2.quant) ? 0 : ((o1.quant > o2.quant) ? -1 : 1);
                    if (compare != 0) {
                        return compare;
                    }
                    return (o1.time > o2.time) ? 1 : -1;
                }
            });
        }
    }
    public static String[] get_top() {
        synchronized(list_trungthu){
            if (list_trungthu.isEmpty()) {
                return new String[]{"Chưa có thông tin"};
            }
            String[] top;
            if (list_trungthu.size() < 10) {
                top = new String[list_trungthu.size()];
            } else {
                top = new String[10];
            }
            for (int i = 0; i < top.length; i++) {
                top[i] = "Top " + (i + 1) + " : " + list_trungthu.get(i).name + " : " + list_trungthu.get(i).quant + " lần";
            }
            return top;
        }
    }
}
