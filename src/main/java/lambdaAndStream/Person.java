package lambdaAndStream;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.MonthDay;

/**
 * @Author: YuTengjing
 * @Date: 2019/1/6
 */
@Data
@AllArgsConstructor
public class Person {
    private String id;
    private String name;
    private boolean sex;
    private int age;
    private MonthDay birthday;
}
