package com.cat.juc;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MyExecutorDemo implements Runnable {

    private String name;

    public MyExecutorDemo(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        System.out.println("I'm " + this.name + ", look at me!");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        //设置了六个线程 所以只能等线程空余了才可以继续执行 否则堵塞
        ExecutorService service = Executors.newFixedThreadPool(6);
        for (int i = 0; i < 10; i++) {
            service.submit(new MyExecutorDemo("Mr Meese" + i));
        }
        service.shutdown();

    }
}
