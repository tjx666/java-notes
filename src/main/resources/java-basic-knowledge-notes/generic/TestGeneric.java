import java.util.Iterator;

/**
 * 泛型 generic
 * 泛型不是范型，两个概念不一样
 * 前者指的是编程语言的提供的一种语法, Java的泛型是一种提供编译期间类型检测和类型自动转换的语法
 * 后者指的是编程风格，比如：oop, fp, mp等
 * 
 * 还有一个词叫泛型编程，这个指的是代码风格，风格要适应各种情况，容错率高，
 * 比如 c++ 中，三段式 for 循环中用 !=，而不是<, 因为并不是所有类型都提供 < 号，但是所有类型都有 !=
 * 
 * Java 泛型和 c++ 模板的区别
 * 有些人说 java 泛型的出现是为了参数化类型，达到类似 c++ 模板的效果
 * 虽然和 c++ 的模板和 java 的泛型其实是完全不同的两个东西
 * Java 的泛型作用在编译器，编译过后没有任何泛型信息，同一个泛型的所有具体类都是一个类
 * c++ 的模板 template 编译期间生成不同的类
 * 
 * Java 泛型出现的意义：
 * Java 泛型并不是为了解决泛化类型的目的。而是为了加强类型检查和提供自动类型转换
 * 如果是要达到泛型化参数的目的，直接全部用 Object 类型声明就好了
 * 
 * 分类： 泛型按照其修饰的对象不同可以分为：
 * 1. 泛型接口
 * 2. 泛型类
 * 3. 泛型方法
 */


public class TestGeneric {
    public static void main(String[] args) {
        
    }

    /**
     * 泛型方法：在返回类型前面声明类型参数即可
     * @param obj
     * @param <T>
     * @return
     */
    public <T> String genericMtToString(T obj) {
        // 还是只能用 Object 中的方法
//        obj.someFunction();
        return "String of specific object is : " + obj.toString();
    }

    /**
     * 使用 object 完全可以做到泛化类型的目的
     * @param obj
     * @return
     */
    public String noGenericMyToString(Object obj) {
        return "String of specific object is : " + obj.toString();
    }
}


/**
 * 泛型约定俗成的类型参数：
 * T 表示 Type
 * E 表示 Element
 * K 表示 Key
 * V 表示 Value
 * @param <E>
 */
interface GenericInterface <E> {
    E add(E newElement);
}








