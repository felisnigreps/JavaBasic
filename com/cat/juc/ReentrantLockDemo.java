package com.cat.juc;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by xugenli on 2017/7/18.
 */
public class ReentrantLockDemo implements Runnable {
    private int id;
    private ReentrantLock lock;

    public ReentrantLockDemo(int id, ReentrantLock lock) {
        this.id = id;
        this.lock = lock;
    }

    @Override
    public void run() {
        //每个任务结束了再开始下一个 否则不释放
        lock.lock();
        try {
            Thread.sleep(1);
            System.out.println(this.id + " go go go!");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(this.id + " is done.");
        lock.unlock();
    }

    public static void main(String[] args) {
        ExecutorService service = Executors.newFixedThreadPool(10);
        ReentrantLock lock = new ReentrantLock();
        for (int i = 0; i < 10; i++) {
            service.execute(new ReentrantLockDemo(i, lock));
        }
        service.shutdown();
    }
}