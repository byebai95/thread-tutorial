package p13_cyclicbarrier;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.TimeUnit;

public class CyclicBarrierDemo {

    private static final CyclicBarrier barrier = new CyclicBarrier(7,new Target());

    public static class Target implements Runnable{
        @Override
        public void run() {
            System.out.println("成功收集 7 颗龙珠， 开始召唤神龙 ...");
        }
    }


    public static void main(String[] args) throws InterruptedException {
        while (true) {
            for (int i = 1; i < 8; i++) {
                final int number = i;
                new Thread(() -> {
                    System.out.println(Thread.currentThread().getName() + ", 收集到龙珠：" + number);
                    try {
                        barrier.await();
                    } catch (InterruptedException | BrokenBarrierException e) {
                        e.printStackTrace();
                    }
                }, "线程" + number).start();
            }
            //判断其他线程执行结束，重置
            while (Thread.activeCount() != 2) {
                TimeUnit.MILLISECONDS.sleep(10);
            }
            barrier.reset();
        }
    }
}
