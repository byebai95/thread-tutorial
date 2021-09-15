package p20_forkjoin;

import java.util.concurrent.ForkJoinPool;

public class ForkJoinPoolDemo {

    public static class MyThread implements Runnable{
        @Override
        public void run() {
            System.out.println("running");
        }
    }

    public static void main(String[] args) {

        ForkJoinPool pool = new ForkJoinPool();

        pool.submit(new MyThread());

        System.out.println(pool.isShutdown());
    }
}
