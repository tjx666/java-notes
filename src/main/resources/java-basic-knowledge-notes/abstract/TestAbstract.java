/**
 * 抽象类: 包含抽象方法的类
 * 抽象方法: 只有方法的声明，没有实现
 */

public class TestAbstract {
    public static void main(String[] args) {
//        Animal a = new Animal(); // 不能实例化
        // 抽象类用于被继承
        Animal animal = new Dog();
        animal.speak();
    }
}


abstract class Animal {
    /**
     * 有些被用于继承的类中某些方法就是被用于重写，抽象类可以将方法的设计和实现分离。
     * 1. 包含了抽象方法那么这个类就是抽象类，必须用用 abstract 修饰类
     * 2. 抽象方法没有方法体
     * 3. 子类必须重写抽象方法，或者子类再次声明为抽象方法，子类变成抽象类
     * 4. 因为抽象类中方法没有实现，所以不能使用 new 实例化抽象类, 可以有构造器，但是不可以被调用
     */
    String words = "I'm a animal";
    
    public Animal() {};
    public abstract void run();
    void speak() {
        System.out.println(this.words); // I'm a animal
    }
}


class Dog extends Animal{
    @Override
    public void run() {
        System.out.println("Cat running....");
    }
}
