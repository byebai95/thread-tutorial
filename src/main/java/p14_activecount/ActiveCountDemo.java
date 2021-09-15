package p14_activecount;

public class ActiveCountDemo {
    public static void main(String[] args) {
        // 输出值为 2 ，为何会有 2 个线程
        System.out.println(Thread.activeCount());

        // main 线程
        // Monitor Ctrl-Break  ,后台监控线程(run 方式启动)
        Thread.currentThread().getThreadGroup().list();
    }
}
