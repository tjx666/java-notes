package jdk7NewFeature;

/**
 * jdk1.7 支持在一个catch块中捕获多个异常
 *
 * 参考连接: https://blog.csdn.net/aqzwss/article/details/46354125
 * @Author: YuTengjing
 * @Date: 2019/1/5
 */
public class MultipleExceptionInOneCatch {
    public static void main(String[] args) {
        try {
            int a = Integer.valueOf(args[0]);
            int b = Integer.valueOf(args[1]);
            System.out.println(a / b);
            // 使用 | 隔开多个异常类型， 当有多个类型时, e被隐式的声明为final
        } catch (ArrayIndexOutOfBoundsException | ArithmeticException e) {
            e.printStackTrace();
            // e是final的，不允许修改
//            e = null;
        }
    }

    static class FirstException extends Exception { }
    static class SecondException extends Exception { }

    // jdk1.7 以前只允许throws Exception
    private void rethrowException(String exceptionName) throws FirstException, SecondException {
        try {
            if (exceptionName.equals("First")) {
                throw new FirstException();
            } else {
                throw new SecondException();
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }
}
