package Java8Date;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.MonthDay;
import java.time.format.DateTimeFormatter;

/**
 * @Author: YuTengjing
 * @Date: 2019/1/3
 */
public class Java8DateFormatter {
    public static void main(String[] args) {
        /*
         * Java8 中该任何格式化DateTime
         */

        LocalDateTime ldt = LocalDateTime.now();
        // 默认格式化
        System.out.println(ldt.toString()); // 2019-01-03T17:18:43.708
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy年MM月dd日 HH时:mm分:ss秒:SSS毫秒");
        // 自定义格式化, 两种方式
        System.out.println(dtf.format(ldt)); // 2019年01月03日 17时:18分:43秒:708毫秒
        System.out.println(ldt.format(dtf)); // 2019年01月03日 17时:18分:43秒:708毫秒

        // 格式化LocalDate和LocalTime同样可以用DateTimeFormat
        System.out.println(MonthDay.now().format(DateTimeFormatter.ofPattern("MM月 dd日"))); // 01月 03日
        System.out.println(LocalTime.now().format(DateTimeFormatter.ISO_LOCAL_TIME)); // 17:26:48.271
    }
}
