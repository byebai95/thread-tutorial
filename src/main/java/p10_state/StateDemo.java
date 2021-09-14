package p10_state;

import java.util.concurrent.TimeUnit;

public class StateDemo {
    public static void main(String[] args) throws InterruptedException {
        Object obj = new Object();
        //线程状态  new , runnable , blocked, waiting, time_waiting , terminated
        Thread t = new Thread(() -> {
            synchronized (obj) {

            }
        });
        t.start();

        TimeUnit.MILLISECONDS.sleep(10);
        System.out.println(t.getState());
    }
}
    /**
     * 线程 6 种状态转换
     * 创建一个新的线程，状态为  new
     * 当线程调用 start 方法后， 状态为 runnable
     * 当线程内使用 sleep , 状态为 time_waiting
     * 当线程内使用 wait ，状态为 waiting
     * 当线程执行结束，为 terminated
     * 当线程需要获取一个已被上锁的对象，则进入 blocked
     */
