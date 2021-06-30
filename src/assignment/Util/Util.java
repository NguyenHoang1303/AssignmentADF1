package assignment.Util;

import java.text.NumberFormat;
import java.util.Locale;

public class Util {
//    Locale formatMoney;

    public static String moneyVND(int money){
        Locale formatMoney = new Locale("nv","VN");//Định dạng locale việt nam
        NumberFormat nf = NumberFormat.getInstance(formatMoney);
        return nf.format(money) + " VNĐ";
    }
}
