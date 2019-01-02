import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;


/**
 * 获取标准输入的3种方式
 */


public class TestStdin {
    public static void main(String[] args) {
//        input1();
//        input2();
//        input3();

        // 使用Scanner的一个坑
        Scanner sc = new Scanner(System.in);
        System.out.println("Please enter your age:");
        // nextInt不会吸收换行符空白符等
        int age = sc.nextInt();
        System.out.println("Please enter your name:");
        String name = sc.nextLine();
        System.out.println(name + "'s age is " + age);
// =>     Please enter your age:
//        21[TAB][\n]
//        Please enter your name:
//        [TAB]'s age is 21
    }
    
    static void input1() {
        // 方式一: 使用System.in.read, System继承于InputStream
        byte[] byteArray = new byte[1024];

        int index = 0;
        try {
            while (true) {
                System.in.read(byteArray, index, 1);
                if (byteArray[index++] == '\n') break;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(new String(byteArray, 0, index));
    }
    
    static void input2() {
        // 方式二: 使用BufferReader 将stdin包装成高级字符流
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = null;
        try {
            str = br.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                br.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        System.out.println(str);
    }
    
    // 方式3: 使用java.util.Scanner类
    static void input3() {
        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine();
        System.out.println(line);
    }
}
