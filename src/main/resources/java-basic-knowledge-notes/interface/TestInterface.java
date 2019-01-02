///**
// * 接口: 接口在很多编程语言里面都有, 比如gO, typescript。接口可以提供了一套规范或者某些已经实现的功能(通过静态方法)，
// * 它不是对对象的抽象，而是对行为的抽象。学习Java中的接口参照typescript中的接口就很好理解。
// * 1. 接口时的属性不允许使用权限修饰符, 总是 public static final
// * 2. 接口的方法在java9以前不允许使用private修饰, 除了public和不使用修饰符的情况小都必须有函数体
// */
//
//public class TestInterface {
//    public static void main(String[] args) {
//        LogOracle log = new LogOracle();
//        log.logInfo("");
//        log.logWarn("");
//        log.logError("");
//        log.logFatal("");
//        LogMySql log1 = new LogMySql();
//        log1.logInfo("");
//        log1.logWarn("");
//        log1.logError("");
//        log1.logFatal("");
//    }
//}
//
//
//final class LogOracle implements Logging {
//}
//
//final class LogMySql implements Logging {
//}
//
//interface Logging {
//    String ORACLE = "Oracle_Database";
//    String MYSQL = "MySql_Database";
//    
//    // 默认时public的，这里的public是多余的
////    public void publicMethod();
//
//    private void log(String message, String prefix) {
//        getConnection();
//        System.out.println("Log Message : " + prefix);
//        closeConnection();
//    }
//
//    default void logInfo(String message) {
//        log(message, "INFO");
//    }
//
//    default void logWarn(String message) {
//        log(message, "WARN");
//    }
//
//    default void logError(String message) {
//        log(message, "ERROR");
//    }
//
//    default void logFatal(String message) {
//        log(message, "FATAL");
//    }
//
//    private static void getConnection() {
//        System.out.println("Open Database connection");
//    }
//
//    private static void closeConnection() {
//        System.out.println("Close Database connection");
//    }
//}
