package com.example.threaddemo;

import org.apache.commons.lang3.concurrent.BasicThreadFactory;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * 依赖 org.apache.commons.lang3.concurrent
 * @author xukai
 */
public class AppScheduledExecutorService {
    public static void main(String[] args) {
        ScheduledExecutorService executor = new ScheduledThreadPoolExecutor(
            1,
            new BasicThreadFactory.Builder().namingPattern("example-%d").build());
        executor.scheduleAtFixedRate(new MyTask(), 2, 5, TimeUnit.SECONDS);

    }

    static class MyTask implements Runnable {
        final String pattern = "yyyy-MM-dd'T'HH:mm:ss";
        public MyTask() {
            String dateString = String.format("%s ", new SimpleDateFormat(pattern).format(new Date()));
            System.out.println("Start   " + dateString) ;
        }

        @Override
        public void run() {
            String dateString = String.format("%s ", new SimpleDateFormat(pattern).format(new Date()));
            System.out.println("Running " + dateString + " " + Thread.currentThread().getName()) ;
        }
    }
}
