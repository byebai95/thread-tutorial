package p01_thread;

/**
 * 通过 Thread 创建一个线程
 */
public class ThreadTest {
    public static void main(String[] args) {

        Thread t = new Thread(() -> {
            System.out.println("重写run方法");
        });

        t.start();

        System.out.println("main 执行");

    }
}
