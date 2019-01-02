import java.util.Comparator;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

/**
 * 比较器 Comparator
 */


public class TestComparator {
    public static void main(String[] args) {
        // linkedHashSet是通过 equals 方法来比较是否要覆盖旧的键
        Set<Student> acquirePrizeStudents = new LinkedHashSet<>();

        acquirePrizeStudents.add(new Student("201626204040", "YuTengjing", 21));
        acquirePrizeStudents.add(new Student("201626204041", "lyr", 20));
        acquirePrizeStudents.add(new Student("201626204042", "dsy", 18));
        acquirePrizeStudents.add(new Student("201626204043", "lyd", 21));
        acquirePrizeStudents.add(new Student("201626204044", "xjp", 19));

        // 必须元素类实现 Comparable接口
        for (Student stu : acquirePrizeStudents) {
            System.out.print(stu.getName() + ' ');
        }
        System.out.println();
        
        TreeSet<Student> tset = new TreeSet<>(new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                return (int) (Long.valueOf(o1.getId()) - Long.valueOf(o2.getId()));
            }
        });
        
        tset.addAll(acquirePrizeStudents);
        for (Student stu : tset) {
            System.out.println(stu.getName());
        }
        System.out.println();
        
        // treeSet 压根没有调用 equals 方法，是根据compareTo 方法来判断是否舍弃重复的键
        TreeSet<Student> tset1 = new TreeSet<>();
        tset1.addAll(acquirePrizeStudents);
        for (Student stu : tset1) {
            System.out.println(stu.getName());
        }
//        YuTengjing lyr dsy lyd xjp
//        YuTengjing
//        lyr
//        dsy
//        lyd
//        xjp
//
//        dsy
//        xjp
//        lyr
//        YuTengjing
    }
}
