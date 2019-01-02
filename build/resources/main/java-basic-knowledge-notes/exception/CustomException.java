/**
 * 自定义异常
 * 只需要继承一个异常类即可
 */

public class CustomException {
    public static void main(String[] args) {
        CustomException ce = new CustomException();
        try {
            ce.test();
        } catch (MyException e) {
            e.printStackTrace();
        }
    }
    
    void test() throws MyException {
        throw new MyException("自定义异常");
    }

    /*
     * throw只能抛出Throwable类及其子类
     * 如果throw可以抛出多种类，那么变相的就可以返回多种类型
     */
//    void testThrow() {
//        throw new String("测试throw能不能抛出非异常对象");
//    }
}


final class MyException extends Exception {
    public MyException() {}
    
    public MyException(String msg) {
        super(msg);
    }
}
