import java.util.*;

/**
 * 测试Collection定义了哪些函数
 */

public class TestCollection {
    public static void main(String[] args) {
        /*
         * Collection 接口位于java.util包类
         * 规定了一些通用接口
         */
        Collection arrayCollection = new ArrayList();
        Collection setCollection = new HashSet();
        // 判断集合是否为空
        System.out.println(arrayCollection.isEmpty());

        
        // 返回容器中元素的个数, 超过 Integer.MAX_VALUE 时返回 Integer.MAX_VALUE
        arrayCollection.add("Java");
        System.out.println(arrayCollection.size()); // 1
        
        
        // add(element) 确保能添加该指定元素，如果已存在，且不允许重复就会返回false
        System.out.println(arrayCollection.add("Javascript"));
        System.out.println(arrayCollection.add("C++"));
        System.out.println(setCollection.add("Python")); // true
        System.out.println(setCollection.add("Python")); // false
        
        
        // remove 如果被指定的元素被删除了返回 true
        System.out.println(arrayCollection.remove("Javascript")); // true
        System.out.println(arrayCollection.remove("Not exists")); // false
        
        
        // contain 判断是否包含指定的元素
        System.out.println(arrayCollection.contains("Javascipt")); // false
        System.out.println(arrayCollection.contains("C++")); // true
        
        
        // 清空
        int count = 10;
        while(count-- != 0) {
            // 在不使用泛型时，容器可以接受任意类型，通过debug可以看到基本类型会被转换成对应得包装类
            arrayCollection.add(count);
        }
        // debug可以看到，尽管clear了，但是容器得容量没有变化
        arrayCollection.clear();
        System.out.println(arrayCollection.size()); // 0
        
        
        // 容器之间得操作
        // 合并
        arrayCollection.addAll(setCollection);
        System.out.println(arrayCollection); // [Python]
        
        
        // 集合求补
        arrayCollection.removeAll(setCollection);
        System.out.println(arrayCollection); // []
        
        
        // 是否为父子集
        System.out.println(arrayCollection.containsAll(setCollection)); // false
        System.out.println(arrayCollection.containsAll(arrayCollection)); // true
        
        
        // 交集 删除指定集合中没有的元素，如果没有删除元素返回 false
        arrayCollection.add("Rust");
        arrayCollection.add("Golang");
        setCollection.add("Golang");
        System.out.println(arrayCollection.retainAll(setCollection)); // true
        System.out.println(arrayCollection); // [Golang]
        
        
        // 转换成数组
        Object[] objArray = arrayCollection.toArray();
        System.out.println(Arrays.toString(objArray)); // [Golang]
    }
}
