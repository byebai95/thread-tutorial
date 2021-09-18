package p21_condition;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ConditionDemo {

    private static final Lock lock = new ReentrantLock();

    // condition 用来代替 Thread.wait() 与 Thread.notify()  ,必须来 locK 块内使用
    private static final Condition condition = lock.newCondition();


    public static class MyThread implements Runnable{
        @Override
        public void run() {
            lock.lock();
            System.out.println("thread running");
            try {
                condition.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("thread running close");
            lock.unlock();
        }
    }



    public static void main(String[] args) throws InterruptedException{
        new Thread(new MyThread()).start();

        TimeUnit.SECONDS.sleep(1);
        lock.lock();
        System.out.println("main running");
        condition.signal();
        System.out.println("main running close");
        lock.unlock();
    }
}
