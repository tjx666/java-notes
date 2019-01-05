package testConsole;

import java.io.Console;
import java.io.PrintWriter;

/**
 * jdk1.6 新增Console类, 有以下用途
 *
 * 1. 方便获取控制台打印流
 * 2. 使用readPassword方法隐藏输入回显
 *
 * @Author: YuTengjing
 * @Date: 2019/1/4
 */
public class TestConsole {
    public static void main(String[] args) {
        // 这个console获取的是没有被重定向的控制台
        Console console = System.console();

        if (console != null) {
            PrintWriter pw = console.writer();
            pw.format("I love %s, but can't hurt you!", "you");

            char[] charArray = console.readPassword("Please input you %s!\n", "password");
            PrintWriter format = pw.format("The password you input is %s", new String(charArray));
        } else {
            System.out.println("Can't get the console");
        }
    }
}
