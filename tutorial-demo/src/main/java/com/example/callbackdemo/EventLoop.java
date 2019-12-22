package com.example.callbackdemo;

import org.apache.commons.lang3.concurrent.BasicThreadFactory;

import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author xukai
 * @date 2019/06/18
 */
public class EventLoop {

    private ScheduledExecutorService executor;
    private OnIntervalCallback callback;

    public EventLoop() {
        this.executor = new ScheduledThreadPoolExecutor(
            1,
            new BasicThreadFactory.Builder().namingPattern("event-loop-%d").build());
    }

    public void addOnIntervalCallback(OnIntervalCallback callback) {
        this.callback = callback;
    }

    public void start(Integer periodSeconds) {
        executor.scheduleAtFixedRate(new Runnable() {
            @Override
            public void run() {
                if (callback != null) {
                    Long tick = System.currentTimeMillis();
                    callback.execute(tick);
                }
            }
        }, 0, periodSeconds, TimeUnit.SECONDS);
    }
}
