import java.util.*;

/**
 * Map 并不是继承自 Collection
 * Collection 存贮的是对象
 * Map 存储的是key不允许重复的 key-value mapping, 即键值映射
 * 并没有说键值对是因为，有些 map 的实现类一个key对应多个value
 *
 * 换句话说：Map 和 Collecton 的区别在于容器保存的元素个数不一样
 * 在 Map 中 Node 保存两个值(key, value), 而 Collection 保存一个值(value)
 * 
 * 不像ES6中的map, Java中的map有些实现类遍历的顺序和插入的顺序不一样
 */


public class TestMap {
    public static void main(String[] args) {
        testMap();
        testHashMap();
    }


    /**
     * 测试Map的api
     * 可以看到同样是容器
     * map也有size, isEmpty, clear
     * 因为存储的是键值映射，所以有很多和 key, value相关的api
     */
    static void testMap() {
        Map map = new HashMap();
        
        map.put("name", "YuTengjing");
        map.put("age", 21);
        map.put("job", "student");
        map.put("grade", 3);
        // 如果键原先不存在，返回null
        System.out.println(map.put("GF", "old GF")); // null
        // 存在 old key, 返回 old key
        System.out.println(map.put("GF", "new GF")); // "old GF"

        // 取值
        System.out.println(map.get("job")); // student
        System.out.println(map.getOrDefault("love", "none")); // none
        
        // HashMap 保存的键值对和插入顺序不一样
        System.out.println(map); // {grade=3, name=YuTengjing, job=student, age=21, GF=new GF}
        
        // 对 key 的操作
        System.out.println(map.keySet()); // [grade, name, job, age, GF]
        System.out.println(map.containsKey("BF")); // false
        
        // 对 value 的操作
        System.out.println(map.values()); // [3, YuTengjing, student, 21, new GF]
        System.out.println(map.containsValue("student")); // true

        // 替old value 不存在时不做任何操作
        System.out.println(map.replace("GF", "jryt")); // new GF
        // 替换成功返回 true, 不存在 key 或 old value 不进行任何操作
        
        System.out.println(map.replace("GF", "jryt", "Secret"));

        // 和Collection一样
        System.out.println(map.size()); // 5
        System.out.println(map.isEmpty()); // false
        map.clear();
        System.out.println(map); // {}
    }


    /**
     * Node<K,V>[] table
     * HashMap 的底层是一个 Node 数组 table，Node 数组的元素是链表，
     * 每个 Node 里面保存一对 key-value
     * 
     * 新添加的 key 放在哪个 Node 里面是根据 key 的 hashcode 通过一系列计算出来的一个 hash 值决定的
     * 不直接用 hashcode 是为了减少 hash 碰撞，即减少 hash 值重复率。
     * 
     * 因为按照先后顺序插入的 key-value 计算出的 hash 值并不是和插入顺序一样的，所以在 hashMap 中
     * 遍历顺序和插入顺序是不一样的
     */
    static void testHashMap() {
        HashMap hashMap = new HashMap();
        
        hashMap.put("China", "BeiJing");
        hashMap.put("America", "New York");
        hashMap.put("Austria", "Canberra");
        hashMap.put("Japan", "ToKyo");
        System.out.println(hashMap); // {Austria=Canberra, China=BeiJing, Japan=ToKyo, America=New York}
        
        hashMap.replace("China", "BeiJin");
        System.out.println(hashMap); // {Austria=Canberra, China=BeiJin, Japan=ToKyo, America=New York}
        // TODO: 集合类待补充, 感觉自己还需要学习。。。
    }
}
