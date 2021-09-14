package P09_join;

import java.util.concurrent.TimeUnit;

public class JoinDemo {

    public static void main(String[] args) throws InterruptedException{

        Thread t = new Thread(()->{
            for(int i=0;i<10;i++){
                System.out.println(Thread.currentThread().getName() + "," + i);
                try {
                    TimeUnit.MILLISECONDS.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"t");
        t.start();
        // join 表示父线程 main 要等子线程 t 结束后再执行
        t.join();
        System.out.println("main 结束");
    }

}
