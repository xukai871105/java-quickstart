package com.example.callbackdemo;

/**
 * @author xukai
 * @date 2019/05/10
 */
public class AppEventLoop {

    public static void main(String[] argv) {
        EventLoop loopA = new EventLoop();
        loopA.addOnIntervalCallback(new OnIntervalCallback() {
            @Override
            public void execute(Long tick) {
                System.out.println("CallbackA " + tick);
            }
        });
        loopA.start(10);

        EventLoop loopB = new EventLoop();
        loopB.addOnIntervalCallback(new MyIntervalCallback());
        loopB.start(20);
    }

    public static class MyIntervalCallback implements OnIntervalCallback{
        @Override
        public void execute(Long tick) {
            System.out.println("CallbackB " + tick);
        }
    }
}
