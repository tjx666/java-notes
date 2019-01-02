/**
 * 常用类Math
 * Math类上绑定了大量的实用静态方法
 */

public class TestMath {
    public static void main(String[] args) {
        // 常量
        System.out.println(Math.PI);
        System.out.println(Math.E);
//        =>
//        3.141592653589793
//        2.718281828459045
        
        
        // 开方
        // 求平方根
        System.out.println(Math.sqrt(9)); // 3.0
        // 立方根
        System.out.println(Math.cbrt(8)); // 2
        
        // 指数运算
        // 一般求幂
        System.out.println(Math.pow(Math.sqrt(10), 2)); // 10.000000000000002
        // 以e为底数的参数次方
        System.out.println(Math.exp(Math.log(10))); // 10.000000000000002
        
        // 对数运算
        // 10为底数对数
        System.out.println(Math.log10(1_0000_0000)); // 8.0
        // 返回e为底数的对数
        System.out.println(Math.log(Math.pow(Math.E, 3))); // 3.0
        // log2(8)该如何计算? 换底公式
        System.out.println(Math.log(8) / Math.log(2));


        // 最大最小, 俩参数类型相同
        System.out.println(Math.max(-0, +0)); // 0
        System.out.println(Math.min(3.0, 3.141592654)); // 3


        // 三角函数
        System.out.println(Math.sin(Math.PI / 6)); //  0.49999999999999994
        System.out.println(Math.cos(Math.PI / 3)); // 0.5000000000000001
        System.out.println(Math.tan(Math.PI / 4)); // 0.9999999999999999
        System.out.println(Math.asin(0)); // 0.0
        System.out.println(Math.acos(1)); // 0.0
        System.out.println(Math.atan(0)); // 0.0
        System.out.println(Math.toDegrees(Math.PI * 2)); // 360.0
        System.out.println(Math.toRadians(180)); // 3.141592653589793

        
        // 求绝对值
        System.out.println(Math.abs(-5.20)); // 5.2
        System.out.println(1314); // 1314
        System.out.println(-0); // 0


        // 取整
        // 四舍五入 round, float返回int类型，double返回long类型
        System.out.println(Math.round(0.4)); // 0
        System.out.println(Math.round(0.5)); // 1
        // 向上取整 ceil
        System.out.println(Math.ceil(665.0000000001)); // 666.0
        System.out.println(998.0); // 998.0
        // 向下取整 floor
        System.out.println(Math.floor(999.999)); // 999.0
        System.out.println(Math.floor(777)); // 777.0
        // 四舍五入，但.5取偶数 Math.floor(x+0.5)
        System.out.println(Math.rint(1.4)); // 1.0
        System.out.println(Math.rint(1.6)); // 2.0
        System.out.println(Math.rint(2.5)); // 2.0
        System.out.println(Math.rint(-1.7)); // -2.0
        

        // 随机函数 [0.0, 1.0)
        System.out.println("*********Math.random*********");
        for (int i = 0; i < 10; ++i) {
            System.out.println(Math.random());
        }
        System.out.println("******************");

        // 取10~20的随机整数
        System.out.println("*********10 ~ 20*********");
        for (int i = 0; i < 10; ++i) {
            System.out.println(10 + (int) Math.floor(Math.random() * 11));
        }
        System.out.println("******************");
        /* =>
            *********Math.random*********
            0.36556090278190356
            0.7352291369010221
            0.3969255159078049
            0.8092847193756089
            0.09025877834255613
            0.9248115303821107
            0.5352811173825319
            0.5418410264130394
            0.12503749516146878
            0.8127687194283802
            ******************
            *********10 ~ 20*********
            12
            18
            13
            20
            11
            20
            19
            12
            19
            18
            ******************
         */
    }
}
