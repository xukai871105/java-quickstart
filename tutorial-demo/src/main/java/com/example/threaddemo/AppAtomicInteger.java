package com.example.threaddemo;

import org.apache.commons.lang3.concurrent.BasicThreadFactory;

import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author xukai
 */
public class AppAtomicInteger {
    private static final AtomicInteger count = new AtomicInteger(0);
    public static void main(String[] args) {
        ScheduledExecutorService executor = new ScheduledThreadPoolExecutor(
            1,
            new BasicThreadFactory.Builder().namingPattern("example-%d").build());
        executor.scheduleAtFixedRate(new Runnable() {
            @Override
            public void run() {
                count.getAndIncrement();
                System.out.println(count);
            }
        }, 2, 5, TimeUnit.SECONDS);

    }
}
