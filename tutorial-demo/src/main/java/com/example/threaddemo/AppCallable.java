package com.example.threaddemo;

import org.apache.commons.lang3.concurrent.BasicThreadFactory;

import java.util.concurrent.*;

/**
 * Callable有返回值
 * @author xukai
 */
public class AppCallable {

    private static final Integer COUNT = 5;

    public static class MyTaskCallable implements Callable<Long> {
        @Override
        public Long call() throws Exception {
            System.out.println(Thread.currentThread().getName() + " start");
            Thread.sleep(2000);
            System.out.println(Thread.currentThread().getName() + " stop");
            return System.currentTimeMillis();
        }
    }

    public static class MyTaskRunable implements Runnable {
        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName() + " start");
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + " stop");
            System.out.println("tick in Runable: " + System.currentTimeMillis());
        }
    }

    public static void main(String[] argv) throws ExecutionException, InterruptedException {
        ScheduledExecutorService scheduler = new ScheduledThreadPoolExecutor(
            1,
            new BasicThreadFactory.Builder().namingPattern("example-%d").daemon(false).build());

        // 通过get方法顺序执行
        for (int i = 0; i < COUNT; i++) {
            Long tick = scheduler.submit(new MyTaskCallable()).get();
            System.out.println("tick: " + tick);
        }

        // 通过get方法顺序执行
        for (int i = 0; i < COUNT; i++) {
            System.out.println();
            scheduler.submit(new MyTaskRunable()).get();
        }


        System.exit(0);
    }
}
