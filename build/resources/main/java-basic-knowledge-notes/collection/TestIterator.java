import java.util.*;

/**
 * 迭代器是一种设计模式
 */


public class TestIterator {
    public static void main(String[] args) {
        /*
         * Iterator 之前有个古老的 Enumeration 接口，现在没什么用了。因为API太少，而且函数名太长
         */
        Vector<Student> students = new Vector<>();

        students.add(new Student("201626204040", "YuTengjing", 21));
        students.add(new Student("201626204041", "lyr", 20));
        students.add(new Student("201626204042", "dsy", 18));
        students.add(new Student("201626204043", "lyd", 21));
        students.add(new Student("201626204044", "xjp", 19));

        Enumeration<Student> elements = students.elements();
        // 遍历方式和 Iterator 类似
        for (Student stu = null; elements.hasMoreElements();) {
            stu = elements.nextElement();
            System.out.println(stu.getName());
        }
        
        // 现在不用 Enumeration，用Iterator
        Iterator<Student> it = students.iterator();
        while (it.hasNext()) {
            // next 返回当前元素，并游标后移
            Student stu = it.next();
            System.out.println(String.format("%s's age is %d", stu.getName(), stu.getAge()));
        }
        // 调用 List.remove(cursor) 删除游标前一个元素, 游标减去一, 即还是指向下一个元素
        it.remove(); 
        System.out.println(students);
//        YuTengjing's age is 21
//        lyr's age is 20
//        dsy's age is 18
//        lyd's age is 21
//        xjp's age is 19 
//        [Student@69d9c55, Student@13a57a3b, Student@7ca48474, Student@337d0578]

        
        // Iterator 在 List 的实现中有更强大的API ListIterator 接口
        ListIterator lit = students.listIterator();
        lit.next();
        // 向前移
        System.out.println(lit.previous()); // S
        // tudent@69d9c55
        System.out.println(lit.previousIndex()); // -1
        System.out.println(lit.nextIndex()); // 0
        
        // 实现了 Iterable 接口就可以使用 for each 循环
        for (Student stu : students) {
            System.out.println(String.format("%s's id is: %s", stu.getName(), stu.getId()));
        }
//        YuTengjing's id is: 201626204040
//        lyr's id is: 201626204041
//        dsy's id is: 201626204042
//        lyd's id is: 201626204043
        // for each 会被编译器替换成使用迭代器遍历的方式，下面是用IDEA反编译的结果
//        Iterator var5 = students.iterator();
//
//        while(var5.hasNext()) {
//            Student stu = (Student)var5.next();
//            System.out.println(String.format("%s's id is: %s", stu.getName(), stu.getId()));
//        }
    }
}


class Student <T> implements Comparable<T> {
    private String id;
    private String name;
    private int age;

    public Student() {}

    public Student(String id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }
    
    public int compareTo(T other) {
        return this.getAge() - ((Student)other).getAge();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}


