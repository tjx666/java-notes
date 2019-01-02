import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Vector;

/**
 * List 在jdk中即线性表，继承自 Collection
 * List 接口有3个继承子类，ArrayList, LinkList, Vector
 * List 相对于 Collection 多了一些和index相关的API
 */
public class TestList {
    public static void main(String[] args) {
//        testListApi();
//        testArrayListApi();
//        testLinkListApi();
        testVector();
    }
    
    
    static void testListApi() {
        List arrayList = new ArrayList();

        int count = 10;
        while (count-- != 0) {
            arrayList.add((char) ((int) 'A' + count));
        }
        System.out.println(arrayList); // [J, I, H, G, F, E, D, C, B, A]
        arrayList.add(arrayList.size(), "Y"); // [J, I, H, G, F, E, D, C, B, A, Y]
        System.out.println(arrayList);
        
        // 根据索引获取元素
        System.out.println(arrayList.get(9)); // A

        // 替换索引处元素
        arrayList.set(0, 'K');
        System.out.println(arrayList); // [K, I, H, G, F, E, D, C, B, A, Y]

        // 删除索引处元素
        arrayList.remove(0);
        System.out.println(arrayList); // [I, H, G, F, E, D, C, B, A, Y]
        
        // 获取某元素的的一个索引
        System.out.println(arrayList.indexOf('C')); // 6

        // 获取某元素的最后一个索引
        arrayList.add(3, 'B');
        System.out.println(arrayList); // [I, H, G, B, F, E, D, C, B, A, Y]
        System.out.println(arrayList.lastIndexOf('B')); // 8

        // 获取索引之间的元素, 获取子序列
        System.out.println(arrayList.subList(0, 9)); //  [I, H, G, B, F, E, D, C, B]
    }

    
    /**
     * 相比List, ArrayList特有的函数
     * 大多是对连续元素和某索引位置的操作
     */
    static void testArrayListApi() {
        ArrayList arrayList = new ArrayList();

        int count = 20;
        while (count-- != 0) {
            arrayList.add((char) ((int) 'A' + Math.floor(Math.random() * 26)));
        }
        System.out.println(arrayList); // [F, P, G, V, M, F, H, V, A, C, B, H, G, Y, F, P, S, W, U, H]
        
        // 将容器大小压缩到和当前元素个数一样，手动回收空间
        arrayList.trimToSize();
        
        // 在指定位置插入一个arrayList
        ArrayList arrayList2 = new ArrayList();
        arrayList2.add('X');
        arrayList2.addAll(1, arrayList); // [X, F, P, G, V, M, F, H, V, A, C, B, H, G, Y, F, P, S, W, U, H]
        System.out.println(arrayList2);
        
        
        // 手动扩容
        arrayList.ensureCapacity(36);
        System.out.println();
    }
    
    
    /**
     * 相比List, LinkedList增加的API
     * 大部分是对首部元素或尾部元素的操作
     */
    static void testLinkListApi() {
        LinkedList linkedList = new LinkedList();
        
        linkedList.add("Google");
        linkedList.add("Miscrosoft");

        // 和首尾相关的add
        linkedList.addFirst("TI");
        // addLast和add源码一模一样
        linkedList.addLast("Sony");
        System.out.println(linkedList); // [TI, Google, Miscrosoft, Sony]
        
        // 和首尾相关的remove
        linkedList.removeFirst();
        linkedList.removeLast();
        System.out.println(linkedList); // [Google, Miscrosoft]
        
        // 在LinkedList中获取首部和尾部元素有好多个函数都可以, 但是是有区别的
        // 下面两个方法在获取不到时会抛出异常
        System.out.println(linkedList.getFirst()); // Google
        System.out.println(linkedList.getLast()); // Miscrosoft
        
        // 使用 peek 获取不到元素时返回 null
        System.out.println(linkedList.peek()); // Google
        // peekFirst和peek源码一模一样
        System.out.println(linkedList.peekFirst()); // Google
        System.out.println(linkedList.peekLast()); // Miscrosoft
        
        // 获取第一个元素并删除第一个元素, 没有第一个元素时，返回null
        System.out.println(linkedList); // [Google, Miscrosoft]
        System.out.println(linkedList.poll());;
        System.out.println(linkedList); // [Miscrosoft]
        linkedList.add("Facebook");
        linkedList.addLast("IBM");
        System.out.println(linkedList);// [Miscrosoft, Facebook, IBM]
        System.out.println(linkedList.pollFirst());
        System.out.println(linkedList); // [Facebook, IBM]
        System.out.println(linkedList.pollLast()); // IBM
        System.out.println(linkedList); // [Facebook]
        // 获取不到返回null
        System.out.println(new LinkedList().pollFirst()); // null

        /**
         * 堆栈函数
         * LinkedList的堆栈函数有点反直觉
         * 一般来讲实现堆栈是把后来的元素放在最后的
         * 但是只要实现FIFO就行了
         */
        // 入栈
        linkedList.push("Intel");
        linkedList.push("TI");
        linkedList.push("Sony");
        System.out.println(linkedList); // [Sony, TI, Intel, Facebook]
        // 出栈
        System.out.println(linkedList.pop()); // Sony
        System.out.println(linkedList); // [TI, Intel, Facebook]
    }

    
    /**
     * 这个 Vector 和 c++ 的 vector 可不是一回事
     * vector内部有一个 protected transient int modCount
     * Vector 长度既会自增也会自减
     * vector tries to optimize storage management by maintaining a
     * capacity and a capacityIncrement
     * 而且很多API都用了synchronized关键字，是线程安全的
     * 因为带element的api错误信息更全面，建议使用带element的api
     */
    static void testVector() {
        // 默认容量还是10
        Vector vector = new Vector();
        
        vector.add("火影忍者");
        vector.add(1, "海贼王");
        // 修改次数加一，再调用 add(object), 进然是 List, 当然还有一个带索引的版本
        vector.addElement("犬夜叉");
        System.out.println(vector); // [火影忍者, 海贼王, 犬夜叉]
        
        // 修改次数加一, 再调用 remove(object), 同样有一个带索引的版本
        vector.removeElement("海贼王");
        System.out.println(vector);
        
        // 获取容量
        System.out.println(vector.capacity());
        
        
        // 获取不到都会报异常，后者错误信息会返回 elementCount
        System.out.println(vector.get(0)); // 火影忍者
        System.out.println(vector.elementAt(1)); // 犬夜叉
        
        // 和上面一样，setElementAt比set的异常错误信息更多
        vector.setElementAt("刀剑神域", 0);
        System.out.println(vector); // [刀剑神域, 犬夜叉]
        vector.set(vector.size() - 1, "东京喰种");
        System.out.println(vector); // [刀剑神域, 东京喰种]
        
        // 底层是数组实现的应该都可以压缩， 链式没有，因为链式的是容量一个一个加的，不存在无用的位置
        vector.trimToSize();
        System.out.println(vector.capacity()); // 2
        
        // 底层是数组实现的应该都可以扩容，链式手动扩容太浪费，应该慢慢扩
        vector.ensureCapacity(60);
    }
}
