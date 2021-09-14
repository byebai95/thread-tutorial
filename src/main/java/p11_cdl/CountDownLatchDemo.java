package p11_cdl;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public class CountDownLatchDemo {

    private static final CountDownLatch latch = new CountDownLatch(2);

    public static void main(String[] args) throws InterruptedException{
        Thread t = new Thread(()->{
            //latch.countDown();
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            latch.countDown();
        });
        t.start();
        latch.await(1,TimeUnit.MILLISECONDS);
        System.out.println("main 执行");
    }

    /**
     *  latch 等待的 2 种方式 ，一种是 countDown 将值减为 0 ，另一种是超时等待
     *
     *   countDown 将值减 1 是采用 compareAndSet , 内部类 Sync 继承 AbstractQueuedSynchronizer ，其内部使用 unsafe 类进行操作
     */
}
