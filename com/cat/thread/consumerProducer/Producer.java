package com.cat.thread.consumerProducer;

import java.util.concurrent.BlockingQueue;

public class Producer implements Runnable {
    BlockingQueue<String> queue;

    public Producer(BlockingQueue<String> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        try {
            String temp = Thread.currentThread().getName();
            queue.put(temp);//如果队列是满的话，会阻塞当前线程
            System.out.println("我制造了一个产品" + Thread.currentThread().getName());

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}