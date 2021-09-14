package p08_volatile;


import java.util.concurrent.TimeUnit;

public class VolatileDemo {

    public static boolean tag = true;

    public static void main(String[] args) throws InterruptedException{

        Thread t1 = new Thread(()->{
            while(tag){
// 验证变量可见性， System.out.println  通过 synchronized 关键字触发 MESI 缓存一致性协议
//               System.out.println("true");
// 线程内 sleep ，变量将不放入线程缓存，无法复现不可见的问题
//                try {
//                    TimeUnit.MILLISECONDS.sleep(100);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
            }
        },"t1");

        Thread t2 = new Thread(()->{
            tag = false;
        },"t2");

        t1.start();
        TimeUnit.MILLISECONDS.sleep(2);
        t2.start();

    }

}
