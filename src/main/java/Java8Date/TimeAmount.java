package Java8Date;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.temporal.ChronoUnit;

/**
 * @Author: YuTengjing
 * @Date: 2019/1/3
 */
public class TimeAmount {
    public static void main(String[] args) {
        /*
         * 时间差相关
         * TemporalAmount 时间差接口有两个实现类
         * {@link Period} is a date-based implementation, storing years, months and days.
         * {@link Duration} is a time-based implementation, storing seconds and nanoseconds,
         */
        LocalDateTime ldt = LocalDateTime.now();

        // Period 和日期时间类接口很类似，也有of, ofDays, parse等
        // 1年+1月+6天之后是哪个日子?
        System.out.println(ldt.plus(Period.of(1, 1, 6)));
        // "-P1Y2M" 等同于 -- Period.of(-1, -2, 0)
        System.out.println(ldt.plus(Period.parse("-P1Y2M")));

        // 加20毫秒
        System.out.println(ldt.plus(Duration.ofMillis(20)));

        // 可以使用时间单元类来获取两个时间之间的时间差
        LocalDate ld1 = LocalDate.of(1999, 11, 11);
        LocalDate ld2 = LocalDate.of(1998, 1, 27);
        System.out.println(ChronoUnit.DAYS.between(ld1, ld2));
    }
}
