package com.cat.jvm;

public class TestGC {

//    -XX:+PrintGC 打印gc日志  -XX:PrintGCDetails


    public Object instance = null;

    private static final int _1MB = 1024 * 1024;

    //作用是占点内存,以便GC更容易观察
    private byte[] bigSize = new byte[2 * _1MB];

    public static void main(String[] args) {
        TestGC a = new TestGC();
        TestGC b = new TestGC();
        a.instance = b;
        b.instance = a;

        a = null;
        b = null;
        System.gc();
    }

}
