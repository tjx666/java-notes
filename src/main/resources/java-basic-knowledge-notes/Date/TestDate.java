import java.util.Date;

/**
 * Java中和时间有关的api
 * 时间戳是当前时刻距离标准时间1970/1/1 0点的毫秒数
 * Date的很多API都被废弃了，尤其是关于年月日时分秒的API
 * Date保留的API都只和时间戳有关，Date的核心功能是处理以毫秒为单位的时间戳
 * 时间戳保存在fastTime这个变量中
 */


public class TestDate {
    public static void main(String[] args) {
        // 获取当前时间戳，单位ms
        System.out.println(System.currentTimeMillis());

        // 空构造器 Date.fastTime = System.currentTimeMillis()
        Date date = new Date();
        System.out.println(date);
        // 获取日期表示的时间戳
        System.out.println(date.getTime());

        // 自定义时间
        // 标准时间0ms
        System.out.println(new Date(0));
        // setTime
        date.setTime(0);
        System.out.println(date);
        
        // 时间比较先后 getMillisOf(this) > getMillisOf(when);
        
        System.out.println(date.after(new Date(-100)));
// =>     1544276862167
//        Sat Dec 08 21:47:42 CST 2018
//        1544276862168
//        Thu Jan 01 08:00:00 CST 1970
//        Thu Jan 01 08:00:00 CST 1970
//        true
    }
}
