import java.util.Scanner;

public class TestStringBuilder {
    public static void main(String[] args) {
        // StringBuilder 出现的比stringBuffer晚，效率比StringBuilder高但是线程不安全
        StringBuilder strBd = new StringBuilder("abc");
        // 使用toString输出构造的字符串
        System.out.println(strBd.toString()); // abc
        
        // api不多，主要用于提高字符串拼接的效率
        // 删除
        
        
        Scanner stdin = new Scanner(System.in);
        for (int time = 1; time <= 3; ++time) {
            // 追加到尾部
            strBd.append(stdin.nextLine());
        }
        System.out.println(strBd.toString());
        /*
        lstrBd.delete(0, strBd.length());
        y
        r
        lyr
         */
        
        // 插入
        strBd.insert(3, " is lovely!");
        System.out.println(strBd.toString()); // lyr is lovely!

        // 追加码点
        strBd.delete(0, strBd.length());
        strBd.appendCodePoint("🛰".codePointAt(0));
        System.out.println(strBd); // 🛰
        
        // java里面怎样拼接字符串和基本类型
        // 用+拼接，效率最低
        String str = "好嗨呦！";
        System.out.println(str + 23333333);
        // 也可以用StringBuilder.append
        System.out.println(new StringBuilder(str).append(23333333)); // 好嗨呦！23333333
        
        // 反转
        System.out.println(new StringBuilder("上海自来水来自海上").reverse()); // 上海自来水来自海上
        
        // 码点类API和String差不多
        System.out.println(new StringBuilder("😋").codePointCount(0, 1)); // 1
        System.out.println(new StringBuilder("😋").codePointAt(0)); // 128523
    }
}
