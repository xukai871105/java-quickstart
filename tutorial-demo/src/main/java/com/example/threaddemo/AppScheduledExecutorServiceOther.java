package com.example.threaddemo;

import com.google.common.util.concurrent.ThreadFactoryBuilder;

import java.util.concurrent.*;

/**
 * 依赖 com.google.guava
 * @author xukai
 */
public class AppScheduledExecutorServiceOther {

    public static void main(String[] argv) {
        runB();
    }

    private static void runB() {
        ScheduledExecutorService service = new ScheduledThreadPoolExecutor(1,
            new ThreadFactoryBuilder().setNameFormat("handle-%d").build(),
            new ThreadPoolExecutor.AbortPolicy());

        service.scheduleAtFixedRate(new Runnable() {
            @Override
            public void run() {
                System.out.println("-------定期任务执行--------");
            }
        }, 0, 5, TimeUnit.SECONDS);
    }

}
