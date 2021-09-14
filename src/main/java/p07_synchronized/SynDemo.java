package p07_synchronized;

public class SynDemo {

    //实例方法可以上锁 this 当前对象
    public void eat(){
        synchronized (this) {

        }
    }

    //不同的写法
    public synchronized void eat2(){

    }

    //类方法，上锁的是 SynDemo.class
    public synchronized static void sleep(){

    }

    public static void sleep2(){
        synchronized (SynDemo.class){
            //
        }
    }


}
