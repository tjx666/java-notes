/**
 * 分析一下hello world程序
 */

// 没有public修饰符也能被jvm直接运行
// 一个java文件可以没有public类
// 一个文件只允许一个public类，理由是java文件中的public类必须和java文件名同
// HelloWorld类不能改成别的类名，否则编译器报错，例如：类 helloWorld 是公共的, 应在名为 helloWorld.java 的文件中声明
public class HelloWorld {
    // 想要被java虚拟机直接执行，必须包含main函数
    // 去掉public报错找不到main方法，所以main方法必须是公开的
    // main方法必须修饰未static
    // main方法参数必须是string数组，否则找不到main方法，函数名和参数类型共同标识一个方法，试试改一下void？
    // 报错找到了main函数，但是返回类型必须定义为void类型
    public static void main(String[] args) {
        // java是根据分号来判断一个语句是否结束，去掉分号报错：需要分号
        // 换行写完全没问题
        String words =
            "hello world";
        System.out.println(words);
    }
}