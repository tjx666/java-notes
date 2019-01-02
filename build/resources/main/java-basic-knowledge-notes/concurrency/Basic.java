import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

/**
 * Java 中并发编程
 * 
 * concurrency 并发
 * parallel 并行，只有在多核或多cpu情况下才有真正的并行
 * 
 * Java 线程的5中状态
 * new 新建状态，只是在堆内存分配内存给线程对象
 * runnable 调用 start 后, 对象从新建状态进入 runnable 状态，jvm 分配 pcr 和 stack 给新线程, 进入线程就绪队列
 * running cpu 调度轮到了 start 的新线程, run 方法被执行，线程进入 running 状态
 * blocked 有多种方法可以进入阻塞状态, wait, yield, join, sleep，阻塞状态指的是在一个时间段内不参与cpu调度
 * 
 * 
 * Java 中使用多线程：
 * 1. 有一个Thread对象
 * 2. 想办法改变这个Thread对象的run方法内容为自己想执行的内容
 */

public class Basic {
    // 主线程
    public static void main(String[] args) throws Exception {
        // Thread 是 java.lang 包的
        System.out.println("Thread " + Thread.currentThread().getName() + " start");

        /*
         * 测试结果表明，优先级越高，越容易被先执行 
         */
//        test1();
//        test2();
//        test3();
        tset4();
        
    }

    /**
     * 简单的多线程示例
     */
    static void test1() {
        Thread thread = new TestThread1();
        // 默认所有线程都是5
        thread.setPriority(8);
        thread.start();
        for (int i = 0; i < 100; i++) {
            System.out.println("Thread "+ Thread.currentThread().getName() + ": " + i);
        }
    }


    /**
     * wait/notify/notifyAll 都是必须在同步块中才可以使用
     * notify 唤醒哪一个等待线程取决于调度算法
     * 当需要判断那个同步资源的条件是否发生变化应该使用循环
     * @throws Exception
     */
    static void test2() throws Exception{
        TestThread2 runnable = new TestThread2();
        runnable.arg = "间接传参";
        Thread thread = new Thread(runnable);
        thread.start();
        Thread.sleep(1000);
        synchronized (runnable.arg) {
            runnable.arg.notify();
        }
    }


    /**
     * 使用多线程的方法三：使用匿名内部类创建新线程，方便无污染
     * 本质上和第二种方式一样
     */
    static void test3() {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                Thread currentThread = Thread.currentThread();
                System.out.println("Thread "+ currentThread.getName() +"'s default priority: " + currentThread.getPriority());
                for (int i = 0; i < 100; i++) {
                    System.out.println("Thread "+ currentThread.getName() + "'s index: " + i);
                }
            }
        });
        thread.start();
        // 使用yield, 强制使当前线程从running进入就绪队列, 但有可能马上又是当前线程继续执行。。。。
        Thread.yield();
        
        Thread currentThread = Thread.currentThread();
        System.out.println("Thread "+ currentThread.getName() +"'s default priority: " + currentThread.getPriority());
        for (int i = 0; i < 100; i++) {
            System.out.println("Thread "+ currentThread.getName() + "'s index: " + i);
        }
    }


    /**
     * 使用多线程的方法四：使用 Callable 创建执行代码 call 方法
     * 为了获取参数，使用FutureTask封装一下call方法，毕竟 Thread 没有提供获取返回值的方法
     * 然后把futureTask转给Thread对象，将target改为futureTask
     * 通过futureTask.get获取返回值
     * @throws Exception
     */
    static void tset4() throws Exception{
        Callable<Integer> callable = new Callable<Integer>() {
            @Override
            public Integer call() {
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    System.out.println("阻塞状态下被打断会报异常：InterruptedException");
                    e.printStackTrace();
                }
                return 666;
            }
        };
        
        FutureTask<Integer> task= new FutureTask<Integer>(callable);
        Thread thread = new Thread(task);
        thread.start();
        thread.interrupt();
        System.out.println(task.get());
    }
//    Thread main start
//    阻塞状态下被打断会报异常：InterruptedException
//    java.lang.InterruptedException: sleep interrupted
//    at java.base/java.lang.Thread.sleep(Native Method)
//    at Basic$2.call(Basic.java:102)
//    at Basic$2.call(Basic.java:98)
//    at java.base/java.util.concurrent.FutureTask.run(FutureTask.java:264)
//    at java.base/java.lang.Thread.run(Thread.java:834)
//        666
}


/**
 * 使用多线程的方法一：继承 Thread 重写 run
 */
class TestThread1 extends Thread {
    @Override
    public void run() {
        // 可以看到 run 方法不能接受参数也没有返回值
        System.out.println("Thread " + Thread.currentThread().getName() + " start");
        for (int i = 0; i < 100; i++) {
            System.out.println("Thread "+ Thread.currentThread().getName() + ": " + i);
        }
    }
}


/**
 * 使用多线程的方法二：继承 Runnable
 */
class TestThread2 implements Runnable {
    // 间接向一个线程传参
    String arg;
    
    @Override
    public void run(){
        System.out.println(this.arg);
        System.out.println("Thread " + Thread.currentThread().getName() + " is running");
        synchronized (arg) {
            try {
                // wait 等待被其它线程唤醒
                // wait/notif/notifyAll 必须在同步代码块中才可以调用，换句话说就是获取锁的时候
                // 而且调用对象必须是获取锁的对象
                arg.wait(10000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
