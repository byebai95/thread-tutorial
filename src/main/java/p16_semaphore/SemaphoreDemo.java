package p16_semaphore;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

public class SemaphoreDemo {

    private static final Semaphore sm = new Semaphore(3);

    public static class CarPort implements Runnable{
        @Override
        public void run() {
            try {
                sm.acquire();
                System.out.println(Thread.currentThread().getName() + "，进入停车场");
                TimeUnit.SECONDS.sleep(Math.round(Math.random() * 3));
                System.out.println(Thread.currentThread().getName() + "，离开了");
                sm.release();
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        CarPort carPort = new CarPort();
        for(int i=1;i<10;i++){
            new Thread(carPort,"车辆"+i).start();
        }


    }

}
