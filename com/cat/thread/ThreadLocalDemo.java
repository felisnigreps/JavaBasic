package com.cat.thread;

public class ThreadLocalDemo {
    //int value;
    //使用ThreadLocal来为每个线程创建一个副本
    ThreadLocal<Integer> value = ThreadLocal.withInitial(() -> 0);

    public int increase() {
        value.set(value.get() + 1);
        return value.get();

    }

    //有5个线程，这5个线程都有一个值value，初始值为0，线程运行时用一个循环往value值相加数字。
    public static void main(String[] args) {
        ThreadLocalDemo demo = new ThreadLocalDemo();
        for (int i = 0; i < 5; i++) {
            new Thread(() -> System.out.println(Thread.currentThread().getName()+".value="+demo.increase())).start();
        }
    }
}
