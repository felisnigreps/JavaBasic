package com.cat.Atomic;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicIntegerArray;

public class AtomicIntegerTest {
    static AtomicInteger i = new AtomicInteger(0);
    static int[] value = new int[]{1,3};
    static AtomicIntegerArray ai = new AtomicIntegerArray(value);

    public static void main(String[] args) {
        System.out.println(i.getAndIncrement());
        System.out.println(i);
        System.out.println(ai.getAndAdd(0,3));
        System.out.println(ai);

    }
}
