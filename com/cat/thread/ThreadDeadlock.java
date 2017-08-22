package com.cat.thread;


public class ThreadDeadlock {

    static class SyncThread implements Runnable {
        private Object object1;
        private Object object2;

        public SyncThread(Object a, Object b) {
            this.object1 = a;
            this.object2 = b;
        }

        @Override
        public void run() {
            String name = Thread.currentThread().getName();
            System.out.println(name + "acquiring lock on" + object1);
            synchronized (object1) {
                System.out.println(name + "acquiring lock on" + object1);
                work();
                System.out.println(name + "acquiring lock on" + object2);
                synchronized (object2) {
                    System.out.println(name + "acquiring lock on" + object2);
                  //  work();
                }
                System.out.println(name + "release lock on" + object2);

            }
            System.out.println(name + "release lock on" + object1);
            System.out.println("finish");
        }
    }

    private static void work() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Object a = new Object();
        Object b = new Object();
        Object c = new Object();
        Thread t1 = new Thread(new SyncThread(a, b), "t1");
        Thread t2 = new Thread(new SyncThread(b, a), "t2");
       // Thread t3 = new Thread(new SyncThread(c, a), "t3");

        t1.start();
       // Thread.sleep(2000);
        t2.start();
      //  Thread.sleep(2200);
     //   t3.start();
    }
}



/*

a需要b才能释放a,b需要a才能释放b,死锁,就是这么简单

Found one Java-level deadlock:
        =============================
        "t2":
        waiting to lock monitor 0x00007fcb0080d8b8 (object 0x000000076aef4090, a java.lang.Object),
        which is held by "t1"
        "t1":
        waiting to lock monitor 0x00007fcb00810148 (object 0x000000076aef40a0, a java.lang.Object),
        which is held by "t2"

        Java stack information for the threads listed above:
        ===================================================
        "t2":
        at com.cat.thread.ThreadDeadlock$SyncThread.run(ThreadDeadlock.java:24)
        - waiting to lock <0x000000076aef4090> (a java.lang.Object)
        - locked <0x000000076aef40a0> (a java.lang.Object)
        at java.lang.Thread.run(Thread.java:745)
        "t1":
        at com.cat.thread.ThreadDeadlock$SyncThread.run(ThreadDeadlock.java:24)
        - waiting to lock <0x000000076aef40a0> (a java.lang.Object)
        - locked <0x000000076aef4090> (a java.lang.Object)
        at java.lang.Thread.run(Thread.java:745)

        Found 1 deadlock.*/

