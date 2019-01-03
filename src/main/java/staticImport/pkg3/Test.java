package staticImport.pkg3;

/**
 * @Author: YuTengjing
 * @Date: 2019/1/3
 */
public class Test {
    public static int staticVariable = 666;
    public static void staticMethod() {
        System.out.println("Static method is invoked!");
    }

    public static class StaticClass {
        public int a = 999;
    }
}
