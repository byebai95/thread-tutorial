package p19_future;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class FutureDemo {

    public static class MyCallable implements Callable<String> {
        @Override
        public String call() throws Exception {
            System.out.println(Thread.currentThread().getName() + " - run callable");
            return "ok";
        }
    }
    public static void main(String[] args) throws ExecutionException, InterruptedException {

        FutureTask<String> futureTask = new FutureTask<>(new MyCallable());

        System.out.println(futureTask.isDone());

        new Thread(futureTask).start();

        System.out.println(futureTask.get());

        System.out.println(futureTask.isDone());

    }
}
