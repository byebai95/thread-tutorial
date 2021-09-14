package p05_yield;


public class YieldDemo {


    public static void main(String[] args) {

        Thread t1 = new Thread(()->{
            System.out.println("t1 running");
        },"t1");

        Thread t2 = new Thread(()->{
            // 从运行状态变为可执行状态/就绪状态，重新抢占 cpu 执行权
            Thread.yield();
            System.out.println("t2 running");
        },"t2");

        t1.start();
        t2.start();

        System.out.println("main running");
    }

}
