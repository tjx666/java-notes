package AutoboxingAndUnboxing;

/*
 * 自动装箱和拆箱
 * JDK1.5 的新特性
 *
 * 参考文章: https://www.cnblogs.com/dolphin0520/p/3780005.html
 * @Author: YuTengjing
 * @Date: 2019/1/2 20:19
 */

/**
 * @Author: YuTengjing
 * @Date: 2019/1/2
 */
public class AutoboxingAndUnboxing {
    public static void main(String[] args) {
        // 自动装箱指的是编译器在合适的时候自动将基本类型通过 valueOf() 转换成对应的包装类
        Integer i1 = 666;

        // 自动拆箱指的是编译器在合适的时候自动将包装类型通过 xxxValue() 转换成其对应的基本类型
        int liu1 = i1;

        // 上面两句代码等同于执行了
        Integer i2 = Integer.valueOf(666);
        int liu2 = i2.intValue();

        test1();
        test2();
        test3();
        test4();

//        上面的代码反编译后可以看到调用了 Integer.valueOf, Integer.intValue
//        $ javap -c AutoboxingAndUnboxing.class
//        Compiled from "AutoboxingAndUnboxing.java"
//        public class AutoboxingAndUnboxing.AutoboxingAndUnboxing {
//          public AutoboxingAndUnboxing.AutoboxingAndUnboxing();
//            Code:
//               0: aload_0
//               1: invokespecial #1                  // Method java/lang/Object."<init>":()V
//               4: return
//
//          public static void main(java.lang.String[]);
//            Code:
//               0: sipush        666
//               3: invokestatic  #2                  // Method java/lang/Integer.valueOf:(I)Ljava/lang/Integer;
//               6: astore_1
//               7: aload_1
//               8: invokevirtual #3                  // Method java/lang/Integer.intValue:()I
//              11: istore_2
//              12: sipush        666
//              15: invokestatic  #2                  // Method java/lang/Integer.valueOf:(I)Ljava/lang/Integer;
//              18: astore_3
//              19: aload_3
//              20: invokevirtual #3                  // Method java/lang/Integer.intValue:()I
//              23: istore        4
//              25: return
//        }
    }

    /**
     * 考察Java的内存优化策略
     *
     * @Date: 2019/1/2 21:34
     * @Param: []
     * @Return: void
     */
    private static void test1() {
        Integer i1 = 127;
        Integer i2 = 127;
        Integer i3 = 666;
        Integer i4 = 666;

        /*
         * 在参与运算时，包装类肯定是要调用valueOf方法获取值后再进行计算的
         * Integer.valueOf 在 -128~127 返回缓存值，不在范围内使用 new Integer() 返回一个新对象
         * 推论:
         * Integer i = new Integer(xxx) 和 Integer i = xxx; 效率和资源占用后者一般效率较高, 后者可能直接返回缓存对象
         */

        System.out.println(i1 == i2);
        System.out.println(i3 == i4);


        // Integer 类重写了equals方法, 内部比较的是intValue
        System.out.println(i1.equals(i2));
        System.out.println(i3.equals(i4));
//        true
//        false
//        true
//        true

    }

    /**
     * Double.valueOf 并没有使用缓存策略, 而是直接 new Double()
     *
     * @Date: 2019/1/2 21:44
     * @Param: []
     * @Return: void
     */
    private static void test2() {
        Double d1 = -128.0;
        Double d2 = -128.0;

        System.out.println(d1 == d2); // false
        System.out.println(Double.valueOf(128.0) == Double.valueOf(-128.0)); // false
    }

    /**
     * Boolean 调用valueOf获取的对象永远是Boolean.TRUE/Boolean.FALSE这两个final static Boolean 对象
     *
     * @Date: 2019/1/2 22:04
     * @Param: []
     * @Return: void
     */
    private static void test3() {
        Boolean b1 = true;
        Boolean b2 = true;

        System.out.println(b1 == b2); // true;
        System.out.println(Boolean.valueOf(true) == Boolean.valueOf(true)); // true
    }

    /**
     * 当自动装箱和拆箱碰到 ==
     *
     * @Date: 2019/1/2 22:12
     * @Param: []
     * @Return: void
     */
    private static void test4() {
        Integer a = 1;
        Integer b = 2;
        Integer c = 3;
        Integer d = 3;
        Integer e = 321;
        Integer f = 321;
        Long g = 3L;
        Long h = 2L;

        // == 两边都是包装类时比较的是地址
        System.out.println(c == d);
        System.out.println(e == f);
        // == 两边一个是对象，一个是基本类型，对象会自动拆箱
        // a+b 先各自拆箱为int值, 左边c也自动拆箱比较大小
        System.out.println(c == (a + b));
        // a+b 先拆箱，得到计算结果再装箱
        System.out.println(c.equals(a + b));
        // 只要 == 两边不都是对象，要调用valueOf拆箱, 比较值大小, g的值为3L, a+b的值为3
        System.out.println(g == (a + b));
        // 重写的equals方法是先判断类型是否相等 obj instanceof Long
        // g的类型为Long, a+b的结果装箱后是Integer
        System.out.println(g.equals(a + b));
        // a和h分别调用的是intValue和longValue，int类型隐式转换为long, 最后的结果有自动装箱为Long
        System.out.println(g.equals(a + h));
//        true
//        false
//        true
//        true
//        true
//        false
//        true
    }


}
