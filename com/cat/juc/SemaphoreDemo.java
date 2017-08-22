package com.cat.juc;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

public class SemaphoreDemo implements Runnable {
    private int i;
    private Semaphore semaphore;

    public SemaphoreDemo(int i, Semaphore semaphore) {
        this.i = i;
        this.semaphore = semaphore;
    }

    @Override
    public void run() {
        try {
            semaphore.acquire();
            System.out.println(this.i + "is running");
            Thread.sleep(2000);
            semaphore.release();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        ExecutorService service = Executors.newFixedThreadPool(10);
        Semaphore limit = new Semaphore(2);
        for (int i = 0; i < 10; i++) {
            service.submit(new SemaphoreDemo(i, limit));
        }
        service.shutdown();
    }
}
