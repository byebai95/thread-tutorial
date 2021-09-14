package p12_rlock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockDemo {

    private static final Lock lock = new ReentrantLock();

    private static Integer counter = 0;

    public static class IncreaseThread implements Runnable{
        @Override
        public void run() {
            lock.lock();
            for(int i=0;i<1000;i++){
                counter += 1;
            }
            lock.unlock();
        }
    }

    public static void main(String[] args) throws InterruptedException{

        IncreaseThread thread = new IncreaseThread();
        Thread t1 = new Thread(thread);
        Thread t2 = new Thread(thread);
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println(counter);
    }

}
