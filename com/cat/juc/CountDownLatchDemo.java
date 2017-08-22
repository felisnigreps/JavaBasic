package com.cat.juc;

import java.util.concurrent.CountDownLatch;

/**
 * Created by xugenli on 2017/4/5.
 */
public class CountDownLatchDemo {
    public static void main(String[] args) {
        //设置一个结束信号
        CountDownLatch end = new CountDownLatch(100);
        //创建100个线程并start
        for (int i = 0; i < 100; i++) {
            new Thread(new Player("CG" + i, end)).start();
        }
        try {
            //countDownLatch在此的作用是等待所有线程执行结束,即100-1执行了100次
            end.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //都结束了打印
        System.out.println("we all done here");
    }

    static class Player implements Runnable {
        private String name;
        private CountDownLatch endSignal;

        public Player(String name, CountDownLatch endSignal) {
            this.name = name;
            this.endSignal = endSignal;
        }

        @Override
        public void run() {
            System.out.println(this.name + "done!");
            //每个线程结束了之后-1
            endSignal.countDown();
        }
    }
}