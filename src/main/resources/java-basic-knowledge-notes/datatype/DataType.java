import java.math.BigInteger;
import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * 整体上Java数据类型分基本数据类型和引用类型
 * 基本类型有：整形（byte, short, int, long），浮点型（float，double），字符型（char），boolean类型
 * 引用类型有： 数组，类，接口，数组，枚举，null,
 * java中只有char类型是无符号数，其它都是有符号数。显然，在整形中，负数比正数多1一个
 */


public class DataType {
    public static void main(String args[]) {
        dataType();
        typeConversion();
        bigDigtal();
    }

    /**
     * 基本类型测试
     */
    private static void dataType() {
        //------------------------------整形------------------------------------//
        // 其实127, 128是int类型，整形字面量都是int，除非加类型后缀
        byte byteVar = 127; // byte类型占内存1个字节，-128 ~ 127
        short shortVar = 128; // short类型占2字节，-32768 ~ 32767， 共65536
        int intVar = 666; // 4字节，最大20多亿
        long longVar = 43_0000_0000L; // 8字节 最大900多亿亿，需要L后最，建议大写
        System.out.println("0b10000000：" + 0b10000000);
        System.out.println("128二进制形式：" + Integer.toBinaryString(128)); // 10000000即00000000 00000000 00000000 10000000
        // 大转小就是直接取低位，丢掉高位
        System.out.println("129强制转换成byte：" + (byte)(128)); // -128 低8位补码为10000000
        System.out.println("256二进制形式：" + Integer.toBinaryString(256)); // 100000000即00000000 00000000 00000001 0000000
        System.out.println("256强制转换byte：" + (byte)(256)); // 0，低8位补码00000000


        //-----------------------------------浮点型------------------------------------------//
        // float 31位是符号位，24 ~ 30共8位是指数位，规定不允许全0或全1，所以范围是-127 ~ 127（排除0），0~23位是尾数位
        float floatVar = 0.1f; // 4字节，浮点数字面量是double类型，声明单精度浮点数需要f后最
        double doubleVar = 3.14159265754; // 8字节
        System.out.println("Double最大值：" + Double.MAX_VALUE + " 指数位位数：" + Double.MAX_EXPONENT);
        // => Double最大值：1.7976931348623157E308 指数位位数：1023
        System.out.println("1.0 / 3: " + (float)(1.0 / 3)); // => 1.0 / 3: 0.33333334 精确小数点后到8位，7位有效数
        System.out.println("1.0 / 3: " + 1.0 / 3); // => 1.0 / 3: 0.3333 3333 3333 3333 精确到小数点后16位，15位有效位
        // java也是采用IEEE754浮点数标准，浮点数是不精确的
        System.out.println(1 - 9.0 / 10); // 0.09999999999999998
        // 判断浮点数是否相等的正确方式：判断差值是否小于某个精度值
        System.out.println(Math.abs(1 - 9.0 / 10 - 0.1) < 1e-8);


        //-------------------------------boolean类型---------------------------------//
        // 虚拟机规范是单个boolean变量占用4个字节，数组元素占1个字节
        boolean isFinish = false;
        System.out.println(isFinish); // false


        //-------------------------------char类型-----------------------------------------//
        char dragon = '龙';
        System.out.println(dragon); // 龙
    }

    /**
     * 类型转换
     */
    private static void typeConversion() {
        //----------------------------------隐式转换----------------------------------------//
        // 在算术运算中，双目运算符两个操作数范围小的类型会向范围大的进行转换
        // 隐式转换也会发生在范围大的类型转范围小的类型
        short sint = 1; // 在这里：int转short，大转小不报错是因为编译器在编译期间就可以判断出该转换没有精度丢失
        // 下面的两行语句报错，因为编译器编译期间无法确定a的大小，为了确保不出错，所以直接报错
        int i = 1;
//        sint = i;
        
        // 小转大往往都可以转并且精度至少不会丢失
        double d = 3.14f;
        System.out.println("d: " + d); // 3.140000104904175 精度变大
        // char是双字节无符号数，但是byte单字节有符号数不能直接转，因为byte包括负数
        byte b;
        char c = 127;
//        b = c; // 报错
        
        // 特殊的，boolean类型允许发生类型转换，和c/c++不一样
//        boolean boolVar = 0; // 报错
        
        
        //-------------------------------强制类型转换-------------------------------//
        // 在我们需要将范围大的数转小的数时，我们可以使用强制类型转换，不然有可能会编译不通过
        sint = 32767; // 不报错
//        sint = 32768; //报错
        sint = (short)32768; // 编译通过
        // 大转小超出范围计算方式就是：整形保留低位
        System.out.println("sint: " + sint); // -32768
        // 浮点型没超出最大范围时去掉部分小数位, 超范围Infinity
        System.out.println((float)3.14159265457); // 3.1415927
        System.out.println(3.0 * Math.pow(2, 128)); // 1.0208471007628154E39
        System.out.println((float)(3.0 * Math.pow(2, 128))); // Infinity
    }

    /**
     * 使用BingInteger处理超大数，BigDecimal处理浮点数精度问题
     */
    private static void bigDigtal() {
        //---------------------BigInteger-----------------------------//
        BigInteger bi1 = new BigInteger("123456789") ;	// 声明BigInteger对象
        BigInteger bi2 = new BigInteger("987654321") ;	// 声明BigInteger对象
        System.out.println("加法操作：" + bi2.add(bi1)) ;	// 加法操作
        System.out.println("减法操作：" + bi2.subtract(bi1)) ;	// 减法操作
        System.out.println("乘法操作：" + bi2.multiply(bi1)) ;	// 乘法操作
        System.out.println("除法操作：" + bi2.divide(bi1)) ;	// 除法操作
        System.out.println("最大数：" + bi2.max(bi1)) ;	 // 求出最大数
        System.out.println("最小数：" + bi2.min(bi1)) ;	 // 求出最小数
        BigInteger result[] = bi2.divideAndRemainder(bi1) ;	// 求出余数的除法操作
        System.out.println("商是：" + result[0] +
            "；余数是：" + result[1]) ;
        
        //-----------------------BigDecimal----------------------------//
        System.out.println("加法运算：" + MyMath.round(MyMath.add(10.345, 3.333),1)) ;
        System.out.println("减法运算：" + MyMath.round(MyMath.sub(10.345, 3.333),3)) ;
        System.out.println("乘法运算：" + MyMath.round(MyMath.mul(10.345, 3.333),4)) ;
        System.out.println("除法运算：" + MyMath.div(10.345,3.333,3)) ;
        
        // =>
//        加法操作：1111111110
//        减法操作：864197532
//        乘法操作：121932631112635269
//        除法操作：8
//        最大数：987654321
//        最小数：123456789
//        商是：8；余数是：9
//        加法运算：13.7
//        减法运算：7.012
//        乘法运算：34.4799
//        除法运算：3.104
    }
}

class MyMath {
    public static double add(double d1,double d2){		// 进行加法计算
        BigDecimal b1 = new BigDecimal(d1) ;
        BigDecimal b2 = new BigDecimal(d2) ;
        return b1.add(b2).doubleValue() ;
    }

    public static double sub(double d1,double d2){		// 进行减法计算
        BigDecimal b1 = new BigDecimal(d1) ;
        BigDecimal b2 = new BigDecimal(d2) ;
        return b1.subtract(b2).doubleValue() ;
    }

    public static double mul(double d1,double d2){		// 进行乘法计算
        BigDecimal b1 = new BigDecimal(d1) ;
        BigDecimal b2 = new BigDecimal(d2) ;
        return b1.multiply(b2).doubleValue() ;
    }

    public static double div(double d1, double d2, int len){		// 进行除法计算
        BigDecimal b1 = new BigDecimal(d1) ;
        BigDecimal b2 = new BigDecimal(d2) ;
        return b1.divide(b2, len, RoundingMode.HALF_UP).doubleValue() ;
    }

    public static double round(double d, int len){	// 进行四舍五入
        BigDecimal b1 = new BigDecimal(d) ;
        BigDecimal b2 = new BigDecimal(1) ; // 技巧
        return b1.divide(b2, len, RoundingMode.HALF_UP).doubleValue() ;
    }
}