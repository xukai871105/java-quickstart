package com.example;

import org.apache.commons.lang3.concurrent.BasicThreadFactory;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author xukai
 */
public class MySimpleTask {

    public static void main(String[] args) {
        ScheduledExecutorService executor = new ScheduledThreadPoolExecutor(
                1,
                new BasicThreadFactory.Builder().namingPattern("example-%d").build());
        /**
         * 初始化延时 2S 周期5秒
         */
        executor.scheduleAtFixedRate(new MyTask(), 2, 5, TimeUnit.SECONDS);

    }

    static class MyTask implements Runnable {
        final String pattern = "yyyy-MM-dd HH:mm:ss";
        public MyTask() {
            String dateString = String.format("%s ", new SimpleDateFormat(pattern).format(new Date()));
            System.out.println("Start:   " + dateString) ;
        }

        @Override
        public void run() {
            String dateString = String.format("%s ", new SimpleDateFormat(pattern).format(new Date()));
            System.out.println("Running: " + dateString + " Thread Name: " + Thread.currentThread().getName()) ;
        }
    }
}
