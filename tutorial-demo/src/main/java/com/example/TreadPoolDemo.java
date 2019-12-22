package com.example;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * 线程池示例
 * @author xukai
 */
public class TreadPoolDemo {

    private static int produceTaskSleepTime = 1000;
    private static int produceTaskMaxNumber = 6;

    public static class ThreadPoolTask implements Runnable {

        private Object threadPoolTaskData;
        ThreadPoolTask(Object tasks) {
            this.threadPoolTaskData = tasks;
        }

        @Override
        public void run() {
            // 处理一个任务，这里的处理方式太简单了，仅仅是一个打印语句
            System.out.println("start .." + threadPoolTaskData);

            while (true) {
                try {
                    //便于观察，等待一段时间
                    Thread.sleep(2000);
                    System.out.println("running .." + threadPoolTaskData);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }

        public Object getTask() {
            return this.threadPoolTaskData;
        }

        public static void main(String[] args) {
            ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(
                4,
                8,
                60,
                TimeUnit.SECONDS,
                new ArrayBlockingQueue<>(3),
                new ThreadPoolExecutor.DiscardPolicy());

            for (int i = 1; i <= produceTaskMaxNumber; i++) {
                try {
                    // 产生一个任务，并将其加入到线程池
                    String task = "task@ " + i;
                    System.out.println("put " + task);

                    threadPoolExecutor.execute(new ThreadPoolTask(task));

                    // 便于观察，等待一段时间
                    Thread.sleep(produceTaskSleepTime);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }

    }
}
