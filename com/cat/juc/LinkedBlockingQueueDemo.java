package com.cat.juc;

import java.util.concurrent.*;

public class LinkedBlockingQueueDemo implements Runnable {
    //使用多个线程往queue里插入数据
    //使用多个线程来取出数据
    //该例子主要展示线程安全 不安全的例子可以使用PriorityQueue代替
    private static BlockingQueue<String> queue = new LinkedBlockingQueue<String>(9);
    private static CountDownLatch count = new CountDownLatch(8);
    private int i;
    private LinkedBlockingQueueDemo(int i) {
        this.i = i;
    }
    public void run() {
        try {
            queue.put(String.valueOf(this.i));
            count.countDown();
            System.out.println(i + " is added!");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        final ExecutorService service = Executors.newCachedThreadPool();
        //多个线程插入数据
        for (int i = 0; i < 8; i++) {
            service.submit(new LinkedBlockingQueueDemo(i));
        }
        //等待插入结束 多个线程取出数据
        try {
            count.await();
            for (int i = 0; i < 8; i++) {
                service.submit(new Runnable() {
                    public void run() {
                        try {
                            System.out.println(queue.take() + " has been taken.");
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                });
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        service.shutdown();
    }
}
