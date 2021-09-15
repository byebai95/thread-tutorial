package p18_executor;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorServiceDemo {

    public static class MyThread implements Runnable{
        @Override
        public void run() {
            System.out.println("running");
        }
    }

    public static void main(String[] args) {

        //单线程执行, 1 核心线程
        ExecutorService singleThreadExecutor = Executors.newSingleThreadExecutor();
        singleThreadExecutor.submit(new MyThread());


        // 0 核心线程
        ExecutorService cachedThreadPool = Executors.newCachedThreadPool();

        // 指定核心线程数量，最大线程数量为 Integer 最大值
        ExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(3);

        // 指定相等的核心线程与最大线程数量
        ExecutorService executorService = Executors.newFixedThreadPool(3);





    }
}
