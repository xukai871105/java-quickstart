package com.example.threaddemo;

import com.google.common.util.concurrent.ThreadFactoryBuilder;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * 依赖 com.google.guava
 * @author xukai
 */
public class ThreadPoolExecutorDemo {

    public static void main(String[] argv) {
        ExecutorService executorService  = new ThreadPoolExecutor(
            Runtime.getRuntime().availableProcessors(),
            Runtime.getRuntime().availableProcessors() * 2,
            60, TimeUnit.SECONDS,
            new LinkedBlockingQueue<>(1000),
            new ThreadFactoryBuilder().setDaemon(false).setNameFormat("handle-%d").build(),
            new ThreadPoolExecutor.AbortPolicy());

        executorService.execute(new MyTask());
    }

    public static class MyTask implements Runnable {
        @Override
        public void run() {
            System.out.println("Start");
            while(true) {
                try {
                    System.out.println("Task: " + System.currentTimeMillis());
                    Thread.sleep(1000);
                } catch (InterruptedException exception) {
                    exception.printStackTrace();
                    break;
                }
            }
        }
    }
}
