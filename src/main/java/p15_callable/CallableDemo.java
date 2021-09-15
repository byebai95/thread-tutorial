package p15_callable;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class CallableDemo {

    public static class MyTask implements Callable<String>{
        @Override
        public String call() throws Exception {
            System.out.println(Thread.currentThread().getName() + ",执行了 call()");
            return "success";
        }
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        FutureTask<String> task = new FutureTask<>(new MyTask());

        Thread t = new Thread(task);

        t.start();

        System.out.println( task.get());
    }
}
