/**
 * 标准输出stdout
 * System.out对象提供了3个API用于将字符串输出到标准输出流
 */


public class TestStdout {
    public static void main(String[] args) {
        // 最常用的println, 带ln表示换行
        System.out.println("I'm not lonely");
        // println重载函数中并没有字符串数组作为参数的,也就是说不能像printf那样传多个字符串参数,来格式化输出
        // 用println输出时，一般拼接字符串有两种方式
        // 方式一: 使用+
        System.out.println("The timestamp of nowTime is " + System.currentTimeMillis());
        // 方式二: 使用 String.format
        System.out.println(String.format("I have %d girl friend. One is my left hand, another is my right hand.", 2));
        
        
        // 有时候我们不需要换行😊，print和println区别只是print不会自动添加换行符
        for (int i = 0; i < 5; ++i) {
            System.out.print((char)((int)Math.floor(Math.random() * 26) + 65) + " 🚀 ");;
        }
        System.out.println();
        // => Z 🚀 X 🚀 H 🚀 D 🚀 C 🚀
        
        
        // 使用printf, 这个和c语言就很像了
        System.out.printf("I hava a %s, I have an %s\n", "pen", "apple"); // I hava a pen, I have an apple
        System.out.printf("%.2f-%-6d-%o-%x", 3.0, 3, 8, 16); // 3.00-3     -10-10
    }
}
