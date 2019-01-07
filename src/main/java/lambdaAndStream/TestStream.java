package lambdaAndStream;

import java.time.MonthDay;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Author: YuTengjing
 * @Date: 2019/1/6
 */
public class TestStream {
    private static List<Person> pals = new ArrayList<Person>() {
        {
            add(new Person("201626204040", "ytj", true, 21, MonthDay.of(1, 27)));
            add(new Person("201626204046", "lyr", false, 20, MonthDay.of(11, 11)));
            add(new Person("201626204042", "dsy", false, 19, MonthDay.of(9, 28)));
            add(new Person("201626204048", "xjp", false, 20, MonthDay.of(6, 26)));
            add(new Person("201626204041", "lyd", true, 21, MonthDay.of(1, 31)));
        }
    };

    public static void main(String[] args) {
//        testForEach();
//        testMap();
//        testFilter();
//        testLimit();
//        testReduce();
//        testToList();
        testMaxAndMin();
    }

    private static void testForEach() {
        pals.stream().forEach(pal -> System.out.println(String.format("%s is %d years old.", pal.getName(), pal.getAge())));
    }

    private static void testMap() {
        pals.stream().map(Person::getName).forEach(System.out::println);
    }

    private static void testFilter() {
        System.out.println("所有的女同学:");
        pals.stream().filter(pal -> !pal.isSex()).map(Person::getName).forEach(System.out::println);
    }

    /**
     * 取前几个,不能取负数
     */
    private static void testLimit() {
        System.out.println("前三个学生");
        pals.stream().limit(3).map(Person::getName).forEach(System.out::println);
    }

    private static void testReduce() {
        // 求2的10次方
        Arrays.stream(new Integer[10]).map(i -> 2).reduce((i1, i2) -> i1 * i2).ifPresent(System.out::print);
    }

    private static void testToList() {
        List<Person> filteredPals = pals.stream()
                .filter(pal -> pal.getBirthday().isBefore(MonthDay.of(3, 1)))
                .collect(Collectors.toList());
        System.out.println("3月份之前出生的:");
        System.out.println(filteredPals);
    }

    private static void testMaxAndMin() {
        System.out.println(pals.stream().max((a, b) -> a.getAge() - b.getAge()));
    }
}
