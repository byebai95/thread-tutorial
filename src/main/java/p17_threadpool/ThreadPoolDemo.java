package p17_threadpool;

import java.util.concurrent.*;

public class ThreadPoolDemo {

    private static Integer counter = 0;

    public static class MyThread implements Runnable{
        @Override
        public void run() {
            for(int i=0;i<10000000;i++) {
                counter += 1;
            }
        }
    }

    public static void main(String[] args) throws InterruptedException{

        ThreadPoolExecutor executor = new ThreadPoolExecutor(
                3,
                10,
                60,
                TimeUnit.SECONDS,
                new ArrayBlockingQueue<>(10));
        executor.execute(new MyThread());

        TimeUnit.SECONDS.sleep(1);
        System.out.println(counter);
    }

    /**
     * corePoolSize 核心线程池大小
     * maximumPoolSize 最大线程池大小
     * keepAliveTime 线程最大空闲时间
     * unit 空闲时间单位
     * workQueue 线程等待队列
     * threadFactory 线程创建工程
     * handler 拒绝策略
     */
}
