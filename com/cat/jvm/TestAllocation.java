package com.cat.jvm;

/**
 * Created by gxu on 2016/12/5.
 */
public class TestAllocation {
    public static final int _1MB = 1024 * 1024;


    public static void main(String[] args) {
        byte[] a,b,c,d;
        a = new byte[2 * _1MB];
        b = new byte[2 * _1MB];
        c = new byte[2 * _1MB];
        d = new byte[4 * _1MB];


    }
}
