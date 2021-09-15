创建线程的三种方式

1. 使用Thread

```java
new Thread().start();
```

​	2.实现 Runnable

```
    public static class MyThread implements Runnable{
        @Override
        public void run() {
            //doSomething
        }
    }

    new Thread(new MyThread()).start();
```

​	3.使用 Callable

```java
  FutureTask<String> task = new FutureTask<>(()->{
        //dodo
        return "ok";
        });

        new Thread(task).start();
```

