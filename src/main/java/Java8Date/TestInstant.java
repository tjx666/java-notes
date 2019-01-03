package Java8Date;

import java.time.*;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * @Author: YuTengjing
 * @Date: 2019/1/3
 */
public class TestInstant {
    public static void main(String[] args) {
        // 测试时间戳类 Instant
        Instant ist = Instant.now();

        // 从Date获取Instant
        ist = new Date().toInstant();

        // 从Calendar获取
        Calendar cale = new GregorianCalendar();
        ist = cale.toInstant();

        // 从LocalDateTime获得
        ist = LocalDateTime.now().atZone(ZoneId.systemDefault()).toInstant();

        // 从ZonedDateTime获得
        ist = ZonedDateTime.now().toInstant();

        // 从LocalDate获的
        ist = LocalDate.now().atStartOfDay().atZone(ZoneId.systemDefault()).toInstant();
    }
}
