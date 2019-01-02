import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * Calendar是负责处理时间戳到日期的转换的一个抽象类
 * 也就是Date类转日期
 * JDK的GregorianCalendar类实现了Calendar
 * 
 * Java中的月份是从0开始， 0表示一月份， 11表示12月
 *  星期从1开始算， 1表示星期天，2表示星期一
 */

public class TestCalendar {
    public static void main(String[] args) {
        // 提供时间戳到年月日等字段的转换
        Calendar cld = new GregorianCalendar();
        cld.set(2018, 11, 8);
        Date date = cld.getTime();
        // 默认的时分秒是当前时间的时分秒
        System.out.println(date);
        System.out.println(cld.getTimeInMillis());
        
        
        // Calendar中定义了一系列月份和星期的常量
        System.out.println(Calendar.SEPTEMBER);
        System.out.println(Calendar.WEDNESDAY);
        
        // set
        cld.set(Calendar.YEAR, 2099);
        cld.set(Calendar.MONTH, 11);
        System.out.println(cld.getTime());
        
        // get
        System.out.println(cld.get(Calendar.YEAR));
        System.out.println(cld.getTimeZone());
        
        
        // 构造器不能使用Date对象或long类型时间戳
//        Calendar calendar = new GregorianCalendar(new Date()); // 没有
        Calendar calendar = new GregorianCalendar();
        calendar.setTime(new Date());
        System.out.println(calendar.getTime());
        
        // 时间计算
        calendar.add(Calendar.MONTH, 1);
        System.out.println(calendar.get(Calendar.YEAR));
        calendar.add(GregorianCalendar.YEAR, -1);
        System.out.println(calendar.get(Calendar.YEAR));
        
// 完整输出 =>        
//        Sat Dec 08 23:14:07 CST 2018
//        1544282047733
//        8
//        4
//        Tue Dec 08 23:14:07 CST 2099
//        2099
//        sun.util.calendar.ZoneInfo[id="Asia/Shanghai",offset=28800000,dstSavings=0,useDaylight=false,transitions=19,lastRule=null]
//        Sat Dec 08 23:14:07 CST 2018
//        2019
//        2018
    }
}
