import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * DateFormat是一个抽象类，主要提供用于处于字符串和Date对象的相互转换
 * SimpleDateFormat是JDK中实现的一个DateFormat，都在java.text包内
 * 主要是提供两个api, format, parse
 */

public class TestDateFormat {
    public static void main(String[] args) {
        // Date对象format为字符串
        DateFormat df = new SimpleDateFormat("[yyyy-MM-dd hh:mm:ss]"); // [2018-12-08 10:23:40]
        Date date = new Date();
        System.out.println(df.format(date));
        
        // 字符串pare为Date对象
        // 车型设置日期字符串格式
        ((SimpleDateFormat) df).applyPattern("MM, dd, yy");
        try {
            System.out.println(df.parse("01, 27, 98")); // Tue Jan 27 00:00:00 CST 1998
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
