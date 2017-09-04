package com.cat.thread;

import java.util.concurrent.TimeUnit;

public class StopThread {

    //一个线程如果没有被同步 那么就有可能不被其他线程看到
    //private static volatile boolean flag = true;

    private static boolean flag = true;

    public static void main(String[] args) throws InterruptedException {
        Thread a = new Thread(new Runnable() {
            @Override
            public void run() {
                int i=0;
                while(flag){
                    i++;
                }
            }
        });
        a.start();
        //Thread.sleep()方法的地方你最好使用TimeUnit.sleep()方法来代替。
        // 它不仅可以提高代码的可读性而且能更加熟悉java.util.concurrent包，因为TimeUnit在并发编程中也是一个关键API
        TimeUnit.SECONDS.sleep(1);

        //这可以正确停止么?
        flag = false;
    }

}
