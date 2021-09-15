package p04_sleep;

/**
 * Thread 本地静态方法 sleep() ，当前线程进行休眠，不释放资源
 */
public class SleepDemo {

    public static class MyThread implements Runnable{
        @Override
        public void run() {
            System.out.println("running");
        }
    }

    public static void main(String[] args) {
        Thread t = new Thread(new MyThread());
        t.start();

        //主线程休眠 1s
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("main");
    }

}
