import java.util.Date;

/**
 * 研究下JAVA数组
 * @author YuTengjing
 */
public class ArrayTest {
    public static void main(String[] args) {
        /*
         * JAVA中的数组都是对象，而c++中的数组只是表示连续的元素
         */
        // ---------------------------三种初始化方式----------------------------------//
        // 推荐用这种
        final int[] array1 = { 1, 2, 3, 4, 5 };
        final int[][] array2 = new int[][] { { 1, 2 }, { 3, 4, 5 }, { 6, 7, 8, 9 } };
        final int[][] array3 = new int[2][3];
        for (int i = 0, k = 0; i < array3.length; ++i) {
            for (int j = 0; j < array3[i].length; ++j) {
                array3[i][j] = k++;
            }
        }
        
        // Java中的数组是有固定长度的，必须在初始化时确定, 下面的代码无法通过编译
//        String strArr = new String[];

        // Java声明数组变量时，类型声明不能带上长度，因为长度无意义，长度不决定数组类型
        // int[5] arr = null; // 报错
        // int[2][] arr1 = null;

        // 使用new []方式初始化必须写上数组长度
        // 使用new []不加长度的方式和不初始化没区别，无意义，必须带上长度
        // int[] intArray = new int[];

        // ------------------------遍历------------------------//
        // 普通的循环遍历
        for (int i = 0; i < array2.length; ++i) {
            for (int j = 0; j < array2[i].length; ++j) {
                System.out.print(array2[i][j] + ", ");
            }
        }
        System.out.println(); // 1, 2, 3, 4, 5, 6, 7, 8, 9,

        // 遍历for
        for (int i : array1) {
            System.out.print(i + ", ");
        }
        System.out.println(); // 1, 2, 3, 4, 5,

        // ------------------------------数组是什么？--------------------------------------//
        // 可以通过引用操作符.调用方法和属性，说明数组是对象类型
        System.out.println(array1.length); // 长度为5
        // array2[1]也是对象类型
        System.out.println(array2[1].toString()); // [I@768debd
        System.out.println(array3[1].hashCode()); // 1225616405

        // 数组在虚拟机中的类名形式为：[ * 维数 + 类型名，数组类可以当作和基本数据类型一样的内建类型
        System.out.println(array1.getClass().getName()); // int[]类在虚拟机中类名名[I
        System.out.println(array3.getClass().getName()); // int[][]类在虚拟机中类名名[[I
        System.out.println(new byte[8].getClass().getName()); // [B
        System.out.println(new long[5][2].getClass().getName()); // [[J
        // 类数组类型名是全限定名，也就是说要加上包名
        System.out.println(new Date[5].getClass().getName()); // [Ljava.util.Date;
        System.out.println(new String[] { "Bob", "Alice" }.getClass().getName()); // [Ljava.lang.String;
        System.out.println(new Boolean[][] { { true }, { false } }.getClass().getName()); // [[Ljava.lang.Boolean;

        // 既然数组有toString,hashcode方法，说明继承了Object, 直接父类会不会是Object？
        System.out.println(array1 instanceof Object);
        System.out.println("the super class of array1: " + array1.getClass().getSuperclass().getName()); // java.lang.Object
        System.out.println("the super class of array3: " + array3.getClass().getSuperclass().getName()); // java.lang.Object

        // 父类数组和子类数组是什么关系？继承关系, 同时继承于Object和父类数组，隐式的多继承
        Integer[] iArray = new Integer[5];
        System.out.println(iArray instanceof Object[]); /// true

        // --------------------------------数组的内存分布-------------------------------------//
        // 多维数组在java中并不是连续的，n维数组是 n-1维数组的 引用 构成的集合
        // 比如 array[2][3], 
        // rray[0]和array[1]指向的堆内存并不是首尾相连，而是离散的任意两块内存，和c/c++不一样
        array3[1] = array1; // 可以指向任意的元素类型相同的数组
        System.out.println(array3[1][4]); // 5
        // array3[1] = array2; // int[][]无法转换为int[]

        // -------------------------------Object数组的应用---------------------------------//
        /*
         * 既可以接收不同类型变量，还可以使用下标访问，以及获取参数长度，灵活，通用 使用string[] 
         * 不能获取不同类型的参数，通用性不强 使用Object接收不能使用下标访问，向下转型有异常风险
         */
        objectArrayApply(new Object[] { 1, false, "abc" });
        /*
         * => 1 false abc
         */
    }

    private static void objectArrayApply(Object[] oArray) {
        System.out.println((Integer) oArray[0]);
        System.out.println((Boolean) oArray[1]);
        System.out.println((String) oArray[2]);
    }
}