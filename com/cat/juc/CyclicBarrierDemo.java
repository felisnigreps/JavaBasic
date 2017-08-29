package com.cat.juc;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by xugenli on 2017/4/10.
 */
public class CyclicBarrierDemo implements Runnable {
    public static void main(String[] args) throws BrokenBarrierException, InterruptedException {
        //四个人喝酒，等人齐了再行动
        ExecutorService service = Executors.newCachedThreadPool();
        CyclicBarrier barrier = new CyclicBarrier(4, () -> System.out.println("All my people are here. Let's go par-ty!"));

        for (int i = 0; i < 4; i++) {
            service.submit(new CyclicBarrierDemo(i, barrier));
        }
        service.shutdown();
    }

    int id;
    CyclicBarrier barrier;

    public CyclicBarrierDemo(int id, CyclicBarrier barrier) {
        this.id = id;
        this.barrier = barrier;
    }

    @Override
    public void run() {
        System.out.println(this.id + " is here!");

        try {
            Thread.sleep(500);
            //到了，等待
            barrier.await();
            //线程之间会互相等待,直到到达barrier,才会结束执行,简单来说,是卡在了await()上
            //System.out.println(this.id);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (BrokenBarrierException e) {
            e.printStackTrace();
        }
    }
}
