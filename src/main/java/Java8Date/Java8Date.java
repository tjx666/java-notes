package Java8Date;

/*
 * Java8
 *
 * 参考连接: https://zhuanlan.zhihu.com/p/28133858
 *
 * @Author: YuTengjing
 * @Date: 2019/1/3 11:21
 */

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.MonthDay;
import java.time.temporal.*;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * @Author: YuTengjing
 * @Date: 2019/1/3
 */
public class Java8Date {
    public static void main(String[] args) {
        /*
         * Java8 在time包中提供了一系列和日期时间相关的包来取代以前的那几个类的原因:
         * 1. 线程不安全，新的time包中的时间日期类都是immutable的
         * 2. 使用不够方便，API太分散，接口不够统一
         */

//        beforeJava8();
//        testLocalDate();
//        testMonthDay();
//        testLocalTime();
        testLocalDateTime();
    }

    private static void beforeJava8() {
        // jdk8 以前我们是怎样处理时间日期的呢?
        // 当前时间戳
        System.out.println(System.currentTimeMillis()); // 1546486077155
        // Date 类来处理时间戳
        Date d = new Date(0);
        // 格林尼治标准时间
        System.out.println(d); // Thu Jan 01 08:00:00 CST 1970
        // Calendar 来处理年月日等字段
        Calendar calendar = new GregorianCalendar(1998, 1, 27);
        System.out.println(calendar.get(Calendar.DAY_OF_MONTH));
        // 时间和字符串的相互转换
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd hh-mm-ss");
        System.out.println(df.format(d));
        Date d1 = new Date(1);
        // 比较时间先后
        System.out.println(d1.after(d));
    }

    private static void testLocalDate() {
        /*
         * 查看源码可以看到LocalDate有三个final成员变量，year, month, day
         * LocalDate不保存时区和时间戳信息，存粹的只保存日期信息
         * 月份从1开始，比Calendar从0开始更容易接受
         * localDate的所有api返回的都是新的LocalDate
         */
        // 使用工厂方法提供当前对象
        LocalDate ld = LocalDate.now();
        System.out.println(ld); // 2019-01-03

        // 获取年月日
        System.out.println(ld.getYear()); // 2019
        System.out.println(ld.getMonth()); // JANUARY
        System.out.println(ld.getDayOfMonth()); // 3

        // 通用的of和parse,这里的通用指的是在LocalTime和LocalDateTime里面也有
        ld = LocalDate.of(1998, 1, 27);
        System.out.println("My birth day: " + ld); // My birth day: 1998-01-27
        // 0天是1970-01-01
        ld = LocalDate.ofEpochDay(3000);
        System.out.println("3000 days after 1970-01-01 is " + ld);
        // => 3000 days after 1970-01-01 is 1978-03-20
        ld = LocalDate.ofYearDay(2019, 1); // 2019-01-01
        System.out.println(ld);

        // 被parse的text格式必须和yyyy-MM-dd一模一样，一位都不能少
        String dateString = "1998-01-27";
        ld = LocalDate.parse(dateString);
        System.out.println(String.format("Parse '%s' to date is : %s", dateString, ld));

        // 查看是否是闰年
        System.out.println(ld.isLeapYear()); // false

        // 判断先后
        System.out.println(ld.plusDays(1).isAfter(ld)); // true
        System.out.println(ld.plusDays(0).isBefore(ld)); // false

        // 日期的计算或者说修改日期, 很简单往后加就是plus, 往前减就用minus
        System.out.println(ld.plusDays(3)); // 1998-01-30
        System.out.println(ld.plusMonths(1)); // 1998-02-27, 看得出来是没有改变原本LocalDate对象
        System.out.println(ld.minusMonths(1)); // 1997-12-27
        // 超过月中最大日就取月中最大日
        System.out.println(ld.plusDays(4).plusMonths(1)); // 1998-02-28

        // 另一种修改日期的方式，通过withXxxx函数修改年月日
        System.out.println(ld.withDayOfMonth(1)); // 1998-01-01
        System.out.println(ld.withMonth(2)); // 1998-02-27
        // TemporalAdjusters定义了大量方便的接口
        System.out.println(ld.with(TemporalAdjusters.firstDayOfMonth())); // 1998-01-01
        System.out.println(ld.with(TemporalAdjusters.firstDayOfNextYear())); // 1999-01-01
    }

    private static void testMonthDay() {
        /*
         * 有时候我们的需求更简单，我们只想要月和日，比如生日
         */

        // 同样的now工厂方法, java8的time包接口很统一
        MonthDay md = MonthDay.now();
        System.out.println(md); // --01-03
        md = MonthDay.of(11, 11);
        System.out.println("Lyr's birthday is: " + md.toString().substring(2)); // Lyr's birthday is: 11-11
        md = MonthDay.parse("--09-28");
        System.out.println("Dsy's borthday is: " + md.toString().replace("-", " "));
        // => Dsy's borthday is:   09 28
        System.out.println(MonthDay.from(LocalDate.of(1998, 1, 27)));
//        System.out.println(LocalDate.from(md));
//        java.time.DateTimeException: Unable to obtain LocalDate from TemporalAccessor: --09-28 of type java.time.MonthDay

        // 判断今天是不是我生日
        System.out.println(MonthDay.now().equals(MonthDay.of(1, 27))); // false
    }

    private static void testLocalTime() {
        LocalTime lt = LocalTime.of(20, 6, 6);
        System.out.println(lt); // => 20:06:06
        System.out.println(LocalTime.parse("00:00")); // 00:00

        System.out.println(lt.getHour());
        System.out.println(lt.getMinute());
        System.out.println(lt.getSecond());
        // 纳秒
        System.out.println(lt.getNano());
//        20
//        6
//        6
//        0
        /*
         * API和LocalDate类似
         * 特性也差不多，和时区以及时间戳无关
         * LocalTime是可以精确到纳秒级别的
         */

        System.out.println(LocalTime.now().getNano()); // 667000000
    }

    private static void testLocalDateTime() {
        /*
         * 和前面几个类差不多，形式: yyyy-MM-ddThh:mm:ss.xxx
         */
        LocalDateTime ldt = LocalDateTime.now();
        System.out.println(ldt); // 2019-01-03T16:39:31.875
        System.out.println(ldt.getNano()); // 875000000

        // 时间域 ChronoField，是TemporalField的一个实现类
        System.out.println(ldt.get(ChronoField.MONTH_OF_YEAR)); // 1
    }
}
