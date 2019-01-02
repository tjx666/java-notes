import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


/**
 * 使用线程池管理线程
 * Java 线程池相关的库都在 util.concurrency中
 */

public class TestThreadPool {
    public static void main(String[] args) {
        test1();
    }
    
    static void test1() {
        ExecutorService pool = Executors.newFixedThreadPool(5);
        
        for (int i = 0; i < 10; i++) {
            pool.submit(() -> {
                Thread currentThread = Thread.currentThread();
                System.out.println(currentThread.getName());
            });
        }
        
        pool.shutdown();
        
        for (; pool.isTerminated();) System.out.println("程序结束");
    }
}
