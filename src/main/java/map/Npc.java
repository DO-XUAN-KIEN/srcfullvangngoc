package map;

import java.io.IOException;
import client.Player;
import core.Manager;
import io.Message;
import io.Session;

public class Npc {
    public static String CHAT_MR_BALLARD = "Chiến trường bắt đầu vào 21h30 phút hàng ngày";
    public static String CHAT_MR_BANANA = "Tao là để đổi quà trang bị 2";
    public static String CHAT_TOP = "Cám ơn các bạn đã like cho mình,hihi!";
    public static String CHAT_PHO_CHI_HUY = "Tao là để đi phó bản kiếm nguyên liệu tinh tú\n" +
            "Và còn chiếm thành bang hội nữa nhé";
    public static String CHAT_PHAP_SU = "Tao là để cường hóa trang bị, khảm ngọc\n" +
            "Tạo mề đay và nâng cấp mề đay";
    public static String CHAT_ZORO = "Tao là để lập bang hội\n" +
            "Cày bang hội cho vip mà cưỡi sư tử";
    public static String CHAT_AMAN = "Tao là để tạo acc khi lên level 10\n" +
            "Hoặc là Chuyển sinh và cất đồ vào rương";
    public static String CHAT_ODA = "Tao là để đi lôi đài pk với nhau\n" +
            "Muốn để tử thì kiếm tao nhé";
    public static String CHAT_LISA ="Tao là để bán vật phẩm nhiều thứ linh tinh\n" +
            "Chắc chắn là rất cần thiết với mày";
    public static String CHAT_SOPHIA ="Tao là để làm sự kiện nếu có\n" +
            "Còn không có thì đừng gặp Tao";
    public static String CHAT_HAMMER = "Tao là để chế tạo đồ, nâng cấp tinh tú và giáp siêu nhân\n" +
            "Nâng skill 110 nữa nhé cu";
    public static String CHAT_ZULU = "Tao là để làm nhiệm vụ hàng ngày\n" +
            "Muốn cuộc sống kiếm thêm nhiều thứ thì gặp";
    public static String CHAT_DOUBA = "Tao là để tìm boss cho chúng mày đấy\n" +
            "Đéo có gì hơn ngoài check boss";
    public static String CHAT_ANNA = "Tao là để nhập gift code nhé\n" +
            "Muốn cởi cái gì thì gặp tao";
    public static String CHAT_BXH = Manager.gI().thongbao;

    public static void chat(Map map, String txt, int id) throws IOException {
        Message m = new Message(23);
        m.writer().writeUTF(txt);
        m.writer().writeByte(id);
        for (int j = 0; j < map.players.size(); j++) {
            Player p0 = map.players.get(j);
            if (p0 != null && p0.map.equals(map)) {
                p0.conn.addmsg(m);
            }
        }
        m.cleanup();
    }
}
