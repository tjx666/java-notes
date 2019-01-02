import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.ParseException;

public class TestExceptionInExtends {
    public static void main(String[] args) {
        
    }
}

class A {
    void mayThrowExceptionMethod() throws IOException {
    }
}


// 子类抛出的异常可以少于父类
class B extends A {
    void mayThrowExceptionMethod() {
        
    }
}


// 抛出运行时异常不受影响
class C extends A {
    void mayThrowExceptionMethod() throws ArithmeticException {
        
    }
}

// 可以抛出父类异常的子类异常
class D extends A {
    void  mayThrowExceptionMethod() throws FileNotFoundException {
        
    }
}


// checked异常种类不超过父类即可
class E extends A {
    void mayThrowExceptionMethod() throws FileNotFoundException, IOException {
        
    }
}

// 编译不通过
//class F extends A {
//    void mayThrowExceptionMethod() throws ParseException {
//        
//    }
//}
