package template;

import java.util.ArrayList;
import java.util.List;

import core.Manager;
import core.Service;
import org.json.simple.JSONArray;
import org.json.simple.JSONValue;

public class Itemshoptt {

    public static List<Itemshoptt> entry = new ArrayList<>();
    public short id;
    public List<Option> op;
    public int price;
    public byte color;

    static {
        String medal
                = "[[4587,[[2,1000],[96,10]],4,100000],"
                + "[4590,[[3,1000],[96,10]],4,100000],"
                + "[4589,[[4,1000],[96,10]],4,100000],"
                + "[4588,[[1,1000],[96,10]],4,100000]]";
        String tt = "[[4756,[[7,2000],[8,2000],[9,2000],[10,2000],[11,2000],[37,1],[27,2000],[28,2000]],4,200000],"
                + "[4757,[[15,2000],[27,2000]],4,50000],"
                + "[4716,[[23,10],[24,10],[25,10],[26,10],[27,1000],[30,1000]],5,75000]"
                + "[4717,[[23,39],[24,39],[25,39],[26,39],[27,1000],[29,1000]],5,100000]"
                
                + "[4760,[[7,5500],[8,5500],[9,5500],[10,5500],[11,5500],[27,5000],[37,1],[38,1],[-71,5000],[-70,5000]],5,300000]]";

        JSONArray js = (JSONArray) JSONValue.parse(medal);
        for (int i = 0; i < js.size(); i++) {
            Itemshoptt temp = new Itemshoptt();
            JSONArray js2 = (JSONArray) JSONValue.parse(js.get(i).toString());
            temp.id = Short.parseShort(js2.get(0).toString());
            Manager.item_sell.get(Service.SHOP_ITEM).add(temp.id);
            temp.op = new ArrayList<>();
            JSONArray js3 = (JSONArray) JSONValue.parse(js2.get(1).toString());
            for (int j = 0; j < js3.size(); j++) {
                JSONArray js4 = (JSONArray) JSONValue.parse(js3.get(j).toString());
                temp.op.add(new Option(Byte.parseByte(js4.get(0).toString()), Integer.parseInt(js4.get(1).toString())));
            }
            temp.color = Byte.parseByte(js2.get(2).toString());
            temp.price = Integer.parseInt(js2.get(3).toString());
            Itemshoptt.entry.add(temp);
        }
        //
        js.clear();
        js = (JSONArray) JSONValue.parse(tt);
        for (int i = 0; i < js.size(); i++) {
            Itemshoptt temp = new Itemshoptt();
            JSONArray js2 = (JSONArray) JSONValue.parse(js.get(i).toString());
            temp.id = Short.parseShort(js2.get(0).toString());
            Manager.item_sell.get(Service.SHOP_ITEM).add(temp.id);
            temp.op = new ArrayList<>();
            JSONArray js3 = (JSONArray) JSONValue.parse(js2.get(1).toString());
            for (int j = 0; j < js3.size(); j++) {
                JSONArray js4 = (JSONArray) JSONValue.parse(js3.get(j).toString());
                temp.op.add(new Option(Byte.parseByte(js4.get(0).toString()), Integer.parseInt(js4.get(1).toString())));
            }
            temp.color = Byte.parseByte(js2.get(2).toString());
            temp.price = Integer.parseInt(js2.get(3).toString());
            Itemshoptt.entry.add(temp);
        }
    }
}
