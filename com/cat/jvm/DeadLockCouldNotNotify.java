package com.cat.jvm;

/**
 * Created by gxu on 2016/12/5.
 */
public class DeadLockCouldNotNotify implements Runnable {
    int a;
    int b;

    public DeadLockCouldNotNotify(int a, int b) {
        this.a = a;
        this.b = b;
    }

    @Override
    public void run() {
        synchronized (Integer.valueOf(a)) {
            try {
                Thread.sleep(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (Integer.valueOf(b)) {
                System.out.println(a + b);
            }
        }
    }

    public static void main(String[] args) {
            new Thread(new DeadLockCouldNotNotify(1, 2)).start();
            new Thread(new DeadLockCouldNotNotify(2, 1)).start();
    }


}
