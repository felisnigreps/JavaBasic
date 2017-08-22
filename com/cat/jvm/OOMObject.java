package com.cat.jvm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by gxu on 2016/12/5.
 */
public class OOMObject {
    byte[] holder = new byte[64 * 1024];


    public static void fill(int num) throws InterruptedException {
        List<OOMObject> list = new ArrayList<OOMObject>();

        for (int i = 0; i < num; i++) {
            list.add(new OOMObject());
            Thread.sleep(50);
        }
        System.gc();

    }
//线程死循环
    public static void createBusyThread(){
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
              for(;;);
            }
        },"busyThread");
        thread.start();
    }

    //线程死锁
    public static void deadLock(final Object lock){
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (lock){
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        },"deadLock");
        thread.start();

    }

    public static void main(String[] args) throws InterruptedException, IOException {
       // fill(1000);

        createBusyThread();
        Object lock = new Object();
        deadLock(lock);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        br.readLine();
    }
}
