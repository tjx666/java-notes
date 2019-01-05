package variableArityMethod;

import java.lang.reflect.Method;

/**
 * Java1.5新增的可变参数，或者说不定长参数
 * 类似于js中的rest参数
 *
 * 参考连接；https://blog.csdn.net/qiuchengjia/article/details/52910888
 * @Author: YuTengjing
 * @Date: 2019/1/4
 */
public class VariableArityMethod {
    public static void main(String[] args) {
        // 一个常用的例子
        String combinedString = String.format("[number]=%d [date]=%s [level]=%s ", 1000, "1月4日", "INFO");
        System.out.println(combinedString); // => [number]=1000 [date]=1月4日 [level]=INFO
        // 查看String.format的函数声明 String format(String format, Object... args)

        // 下面两个执行效果是一样的
        testVariableArgMethod(666, 999, 23333);
        testVariableArgMethod(new int[]{ 666, 999, 23333 });

        test1();
    }

    private static void testVariableArgMethod(int ...rest) {
        // 说明运行时, 可变参会被转换成一个数组
        System.out.println(rest.getClass().getTypeName().equals(int[].class.getTypeName())); // true
        int index = 0;
        for (int i : rest) {
            System.out.println(String.format("Arg%d: %s", index++, i));
        }
    }

    // 不能同时声明等价的参数为数组的方法
//    private static void testVariableArgMethod(int[] rest) {}

    private static void test1() {
        // 可变参和数组形式参数方法签名是一样的，多态同样有效
        Father f = new Son();
        f.print(""); // Son...
        // 编译不通过
//        Son s = new Son();
//        s.print("");
    }
}


class Father {
    void print(String ...args) {
        System.out.println("Father....");
    }
}

class Son extends Father {
    @Override
    void print(String[] args) {
        System.out.println("Son...");
    }
}

// 关于反射中的一个可能会遇到的问题
class Test {
    // 运行时方法参数已经是String[]类型，意思就是说参数个数为1，invoke是Object类型可变参，传任意数组都会被转型成Object[]
    public static void foo(String... varargs){
        System.out.println(varargs.length);
    }

    public static void test(String[] args){
        String[] varArgs = new String[]{"arg1", "arg2"};
        try{
            Method method = Test.class.getMethod("foo", String[].class);
            method.invoke(null, varArgs);
            method.invoke(null, (Object[])varArgs);
            method.invoke(null, (Object)varArgs);
            method.invoke(null, new Object[]{varArgs});
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}

//Object invoke(Object obj, Object... args)
//String[] varArgs = new String[]{"arg1", "arg2"};
//method.invoke(null, varArgs); //varArgs长度为2，错误
//method.invoke(null, (Object[])varArgs); //将String[]转换为Object[],长度为2的，错误
//method.invoke(null, (Object)varArgs);//将整个String[] 转为Object，长度为1，符合
//method.invoke(null, new Object[]{varArgs});//Object[]长度为1，正确。上一个和这个是等价的
