package com.example.threaddemo;

/**
 * 根据代码规范，禁止这样使用
 * @author xukai
 */
public class ThreadDemo {
    public static void main(String[] argv) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Start");
                while(true) {
                    try {
                        System.out.println("Task: " + System.currentTimeMillis());
                        Thread.sleep(1000);
                    } catch (InterruptedException exception) {
                        exception.printStackTrace();
                    }

                }
            }
        }).start();
    }


}
