package p03_exthread;

public class ExThread {

    public static class MyThread extends Thread {
        @Override
        public void run() {
            System.out.println("继承 Thread");
        }
    }

    public static void main(String[] args) {
        MyThread t = new MyThread();
        t.start();
    }
}
