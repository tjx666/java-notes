package Java8Date;

import java.time.*;
import java.time.temporal.TemporalAdjusters;
import java.util.Date;

/**
 * @Author: YuTengjing
 * @Date: 2019/1/3
 */
public class Java8Zone {
    public static void main(String[] args) {
        /*
         * 时区
         * Java.time 包很多日期和时间类都不保存时区信息的
         */

        LocalDateTime ldt = LocalDateTime.now();
        System.out.println(ldt);
        // atZone 方法调用的是 ZonedDateTime.of(LocalDateTime localDateTime, ZoneId zone)
        // 结果返回一个修改了时区为指定时区的ZonedDateTime
        System.out.println(ldt.atZone(ZoneId.of("Europe/Paris")));
        System.out.println(ldt.atZone(ZoneId.of("America/New_York")));
//        2019-01-03T19:53:14.627
//        2019-01-03T19:53:14.627+01:00[Europe/Paris]
//        2019-01-03T19:53:14.627-05:00[America/New_York]

        ZonedDateTime zdt = ZonedDateTime.now(ZoneId.of("Europe/Paris"));
        System.out.println(zdt); // 2019-01-03T13:06:06.480+01:00[Europe/Paris]

        // 那么任何进行时区转换
        // 先获取时间戳
        Instant timeStamp = ldt.atZone(ZoneId.systemDefault()).toInstant();
        LocalDateTime parisDt = LocalDateTime.ofInstant(timeStamp, ZoneId.of("Europe/Paris"));
        System.out.println(parisDt);
//        2019-01-03T13:27:13.355+01:00[Europe/Paris]
//        2019-01-03T13:27:13.341
    }
}
