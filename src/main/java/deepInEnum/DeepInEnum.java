package deepInEnum;

/**
 * jdk1.5新增的枚举
 * <p>
 * 参考连接:
 * 1. https://blog.csdn.net/javazejian/article/details/71333103
 * 2. https://blog.csdn.net/qq_27093465/article/details/52180865
 * <p>
 * 关于枚举上面两个连接的文章很详细了，我下面就简单测试一下
 *
 * @Author: YuTengjing
 * @Date: 2019/1/4
 */
public class DeepInEnum {
    public static void main(String[] args) {
        // 通过枚举类直接获取枚举成员
        // JAVA中的枚举没有枚举值的概念, 其它一样一般枚举成员默认是第一个成员枚举值1，然后逐个加一
        Season spring = Season.SPRING;
        System.out.println(spring.toString()); // SPRING

        // 可以看到枚举类Season继承自Enum
        Enum summer = Season.SUMMER;
        /*
         * Enum类是个什么类呢?
         * public abstract class Enum<E extends Enum<E>> implements Comparable<E>, Serializable
         *
         * Enum类是一个实现了Comparable<E>, Serializable接口的抽象类
         * 抽象类意味着它实现了一部分实例方法
         *
         * 枚举类继承了Enum, 意味着枚举类不能继承其它类，不过可以通过实现接口来扩展
         */
        // Enum的 order in all 属性, 从0开始
        System.out.println(summer.ordinal()); // 1
        // Enum.name 枚举成员的变量名
        System.out.println(spring.name()); // SPRING
        // values函数是编译器自动生成的, 返回枚举类成员数组
        for (Season s : Season.values()) {
            System.out.println(s);
        }
        /*
         SPRING
         SUMMER
         AUTUMN
         WINTER
         */
        // 另一种初始化枚举变量的方式
        Season s = Enum.valueOf(Season.class, "WINTER");
        System.out.println(s.name()); // WINTER


        // 场景一: 统一管理常量，就像下面的季节枚举类
        // 场景二: 配合 switch, case中的条件选项一般都是常量。而且个数有限。switch case和enum 简直是天生绝配
        Season season = Season.AUTUMN;
        switch (season) {
            case SPRING:
                System.out.println("spring");
                break;
            case SUMMER:
                System.out.println("summer");
                break;
            case AUTUMN:
                System.out.println("autumn");
                break;
            case WINTER:
                System.out.println("winter");
                break;
            default:
                ;
        }
        // 场景三: 当枚举类多了，怎样有效管理枚举类? --- 使用接口
        Food.Vegetable tomato = Food.Vegetable.TOMATO;
        System.out.println(tomato.name());

        // 场景四: 自定义枚举
        ProgrammingLanguages pl = ProgrammingLanguages.JAVASCRIPT;
        System.out.println(pl.getDescription());


    }
}


// 最简单的枚举类, 枚举变量用大写和下划线方式, 把 enum 关键字当 class 关键字用
// 枚举类也是类
enum Season {
    SPRING, SUMMER, AUTUMN, WINTER
}

// 枚举类是不能再继承的，因为所有的枚举类都已经继承自Enum类
//enum EnumClass extends DeepInEnum {}


interface Food {
    enum Fruit {
        APPLE, BANANA, PEAR, ORANGE
    }

    enum Vegetable {
        CABBAGE, TOMATO, POTATO
    }
}


// 如果要在枚举中添加额外的属性或方法最后一个枚举成员后面要使用分号,并且重写非公有构造函数
enum ProgrammingLanguages {
    JAVA(1, "Java web is very popular today!"),
    PYTHON(2, "Python is very convient!"),
    JAVASCRIPT(3, "any application that can be written in JavaScript, will eventually be written in JavaScript");

    private int value;
    private String description;

    public void setValue(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    private ProgrammingLanguages(int value, String description) {
        this.value = value;
        this.description = description;
    }

    public static ProgrammingLanguages fromName(String name) {
        for (ProgrammingLanguages pl : ProgrammingLanguages.values()) {
            if (name.equals(pl.name())) return pl;
        }
        return null;
    }
}