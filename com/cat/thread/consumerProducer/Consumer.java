package com.cat.thread.consumerProducer;

import java.util.concurrent.BlockingQueue;

public class Consumer implements Runnable{
    BlockingQueue<String> queue;

    public Consumer(BlockingQueue<String> queue){
        this.queue = queue;
    }

    @Override
    public void run() {
        try {
            String temp = queue.take();//如果队列为空，会阻塞当前线程
            System.out.println("消费者拿走了一个产品"+temp+", 剩余"+queue.size());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
