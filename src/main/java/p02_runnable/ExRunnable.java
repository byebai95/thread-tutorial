package p02_runnable;


/**
 * 使用实现 Runnable 接口创建线程
 */
public class ExRunnable {

    public static class MyThread implements Runnable {
        @Override
        public void run() {
            System.out.println("继承 runnable");
        }
    }

    public static void main(String[] args) {
        MyThread thread = new MyThread();
        Thread t = new Thread(thread);
        t.start();
    }
}
