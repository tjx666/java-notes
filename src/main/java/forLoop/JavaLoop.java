package forLoop;

import java.time.MonthDay;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 来总结一下java的循环
 *
 * jdk1.5关于循环做了增强
 * 1. 新增Iterable接口，Iterable接口实现类必须重写Iterator方法，返回一个Iterator对象
 *  Iterable接口还默认实现了forEach函数。由于Java集合类都实现了Iterable接口，因此集合类都可以使用forEach来遍历
 * 2. jdk1.5新增的遍历for循环, 即形式为 for (type : set)
 *
 * @Author: YuTengjing
 * @Date: 2019/1/3
 */
public class JavaLoop {
    public static void main(String[] args) {
//        infiniteLoop();
//        multipleLoop();
//        enhancedForLoop();
        forEachLoop();
    }

    /**
     * 聊聊Java中的无限循环
     */
    private static void infiniteLoop() {
        // 最常见的 while (true)
//        while (true) {
//            System.out.println("I love you!");
//        }

        // for 循环其实也可以, 还是觉得上面那种更优雅一点
//        for (;;) {
//            System.out.println("💕");
//        }
    }

    /**
     * 多重循环
     */
    private static void multipleLoop() {
        // 怎样跳出多层循环?
        // 方式一: 设一个标志, 让外层循环知道你是从内层中断循环跳出来的
        // 下面的示例要在i = 3, j = 3时跳出两重循环，其它情况下打印[i, j]
        boolean flag = true;
        for (int i = 0; i < 5; i++) {
            if (!flag) break;
            System.out.println("Inner loop execute...");
            for (int j = 0; j < 5; j++) {
                if (i == 3 && j ==3) {
                    flag = false;
                    break;
                }
                System.out.println(String.format("[%s, %s]", i, j));
            }
        }
        System.out.println("//--------------------------------------------------");

        // 方式二: 使用带标签的break
        // 注意: java 中没有goto, 但是goto是保留字，说不定以后java高版本支持goto
        // java 中break和continue支持带标签形式，有点像报废版的goto
        // 还是上面那个例子
        doubleLoopOut:
        for (int i = 0; i < 5; i++) {
            System.out.println("Inner loop execute...");
            for (int j = 0; j < 5; j++) {
                if (i == 3 && j ==3) break doubleLoopOut;
                System.out.println(String.format("(%s, %s)", i, j));
            }
        }
        System.out.println("//--------------------------------------------------");

        // 来测试一下带标签的continue
        // 结果和直接break的效果一样，continue tag;效果是从tag后的循环部分开始下一轮循环
        continueTag:
        for (int i = 0; i < 5; i++) {
            System.out.println("Inner loop execute...");
            for (int j = 0; j < 5; j++) {
                if (i == 3 && j ==3) continue continueTag;
                System.out.println(String.format("|%s, %s|", i, j));
            }
        }
    }

    /**
     * 增强型for循环
     */
    private static void enhancedForLoop() {
        String[] firms = new String[]{ "Microsoft", "Google", "Facebook" };
        for (String firm : firms) {
            System.out.print(firm + "   ");
        }
        System.out.println();

        // 上面的代码反编译的结果是:
//        String[] firms = new String[]{"Micro soft", "Google", "Facebook"};
//        String[] var1 = firms;
//        int var2 = firms.length;
//
//        for(int var3 = 0; var3 < var2; ++var3) {
//            String firm = var1[var3];
//            System.out.print(firm + "   ");
//        }
//
//        System.out.println();

        /*
         * 从反编译的结果可以看出编译器在处理数组的遍历for循环只是将其转换下三段式下标for循环
         */

        // 集合类也可以使用遍历for
        List<Integer> ls = new ArrayList<>();
        ls.add(666);
        ls.add(999);
        ls.add(686);
        for (int i : ls) {
            System.out.print(i + "  ");
        }

        // 反编译的结果为:
//        System.out.println();
//        List<Integer> ls = new ArrayList();
//        ls.add(666);
//        ls.add(999);
//        ls.add(686);
//        Iterator var6 = ls.iterator();
//
//        while(var6.hasNext()) {
//            i = (Integer)var6.next();
//            System.out.print(i + "  ");
//        }

        /*
         * 可以看到对于实现了Iterable接口的类，编译器调用了对象的iterator函数来转换
         */
    }

    /**
     * forEach循环，函数式风格, 结合lambda和方法引用，很装逼
     */
    private static void forEachLoop() {
        MonthDay[] birthdayArray = new MonthDay[]{
                MonthDay.of(1, 27),
                MonthDay.of(11, 11),
                MonthDay.of(9, 28),
                MonthDay.of(6, 28)
        };

        List<MonthDay> birthdayList = Arrays.asList(birthdayArray);
        birthdayList.forEach(System.out::print);
        System.out.println();
//        --01-27--11-11--09-28--06-28
    }
}
