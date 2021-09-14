package p06_wait;



public class WaitDemo {

    private static Integer number = 0;

    public static class SumThread extends Thread {
        @Override
        public synchronized void run() {
            for (int i = 0; i < 100; i++) {
                number += 1;
            }
            this.notify();
        }
    }


    public static void main(String[] args) {
        SumThread sumThread = new SumThread();
        sumThread.start();
        synchronized (sumThread) {
            try {
                sumThread.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(number + 10);
        }
    }


}
