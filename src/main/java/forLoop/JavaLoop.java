package forLoop;

/**
 * 来总结一下java的循环
 *
 * jdk1.5关于循环做了增强
 * 1. 新增Iterable接口，Iterable接口实现类必须重写Iterator方法，返回一个Iterator对象
 *  Iterable接口还默认实现了forEach函数
 * 2. 只要对象实现了Iterable接口，该对象就可以使用jdk1.5新增的遍历for循环
 *
 * @Author: YuTengjing
 * @Date: 2019/1/3
 */
public class JavaLoop {
    public static void main(String[] args) {
//        infiniteLoop();
        multipleLoop();
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
}
