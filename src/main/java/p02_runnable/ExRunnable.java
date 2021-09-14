package p02_runnable;

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
