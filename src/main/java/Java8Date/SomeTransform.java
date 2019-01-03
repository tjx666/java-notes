package Java8Date;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.TimeZone;

/**
 * @Author: YuTengjing
 * @Date: 2019/1/3
 */
public class SomeTransform {
    public static void main(String[] args) {
        /*
         * 一些转换
         */

        //  LocalDateTime 转 Date
        LocalDateTime ldt = LocalDateTime.now();
        Date d = Date.from(ldt.atZone(ZoneId.systemDefault()).toInstant());

        // Date 转 LocalDateTime
        ldt = LocalDateTime.ofInstant(d.toInstant(), ZoneId.systemDefault());

        // LocalDate 转 Date
        d = Date.from(LocalDate.now().atStartOfDay().atZone(ZoneId.systemDefault()).toInstant());

        // 获取所有时区id
//        for (String id : TimeZone.getAvailableIDs()) {
//            System.out.println(id);
//        }

        Calendar cale = new GregorianCalendar();
        System.out.println(cale.getTimeZone());
        TimeZone tz = TimeZone.getDefault();
        tz = TimeZone.getTimeZone("UTC+8");
        System.out.println(tz);
        // TimeZone 转 ZoneId
        ZoneId zid = tz.toZoneId();
        // ZoneId转TimeZone
        tz = TimeZone.getTimeZone(zid);

        /*
         * 时区有很多表示方法
         * 1. 形如 Asia/Shanghai 大地方/城市
         * 2. 类似 CST 即China Standard Time, UTC 格林尼治标准时间
         */

    }
}
