package java8Lambda;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: YuTengjing
 * @Date: 2019/1/5
 */
public class SImpleTest {
    public static void main(String[] args) {
        Thread thread = new Thread(() ->{
            System.out.println("lulalulala");
        });

        thread.start();

        List<Person> personList = new ArrayList<Person>() {
            {
                add(new Person("ly", 21));
                add(new Person("lyr", 20));
                add(new Person("dsy", 20));
            }
        };
    }
}


@Data
@AllArgsConstructor
class Person {
    private String name;
    private int age;
}
