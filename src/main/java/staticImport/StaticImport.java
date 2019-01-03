package staticImport;

import static java.lang.Math.*;
// 精确导入
import static staticImport.pkg1.ConstantInterface1.LYR_BIRTHDAY;
import static staticImport.pkg2.ConstantInterface2.*;
import static staticImport.pkg3.Test.*;

/*
 * JDK1.5 新特性之静态导入
 *
 * 参考文章: https://blog.csdn.net/xyz_fly/article/details/8178104?spm=5176.100034.1.11.b95b654fVKp9KY
 * @Author: YuTengjing
 * @Date: 2019/1/2 22:57
 */

/**
 * @Author: YuTengjing
 * @Date: 2019/1/2
 */
public class StaticImport {
    public static void main(String[] args) {
        // 先来看一个例子
        // 现在需要获取一个1~20之间的随机整数
        int r = (int)Math.floor(Math.random() * 20 + 1.0);

        // 使用静态导入的话, 用起来方便多了，并且floor 和 random 还是比较特殊的，不太容易造成命名冲突问题
        r = (int)floor(random() * 20 + 1.0);

        // 精确导入pkg1.ConstantInterface1.LYR_BIRTHDAY
        System.out.println(LYR_BIRTHDAY);

        // 使用通配符导入所有被static修饰的标识符
        System.out.println(JAVA_VERSION);
        System.out.println(PROJECT_NAME);
        System.out.println(BUILD_TOOL);

        // 只要是static修饰的就可以被static import
        StaticClass sc = new StaticClass();
        System.out.println(sc.a);

        // 下面是IDEA反编译的结果，可以看到使用静态导入并不会造成性能上的损失
        // 静态成员一部分直接被常量替换了，比如字符串 "java-notes"
        // 编译过后是没有static import相关的信息的
//        import staticImport.pkg1.ConstantInterface1;
//        import staticImport.pkg2.ConstantInterface2;
//        import staticImport.pkg3.Test.StaticClass;
//
//        public class StaticImport {
//            public StaticImport() {
//            }
//
//            public static void main(String[] args) {
//                int r = (int)Math.floor(Math.random() * 20.0D + 1.0D);
//                r = (int)Math.floor(Math.random() * 20.0D + 1.0D);
//                System.out.println(ConstantInterface1.LYR_BIRTHDAY);
//                System.out.println(ConstantInterface2.JAVA_VERSION);
//                System.out.println("java-notes");
//                System.out.println("Gradle");
//                StaticClass sc = new StaticClass();
//                System.out.println(sc.a);
//            }
//        }


        // 静态导入造成的冲突问题参考上面的参考连接
    }
}
