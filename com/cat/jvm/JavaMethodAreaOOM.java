package com.cat.jvm;

/**
 * Created by gxu on 2016/12/1.
 */
public class JavaMethodAreaOOM {
    Object instance;

    public static void main(String[] args) {
        JavaMethodAreaOOM a = new JavaMethodAreaOOM();
        JavaMethodAreaOOM b = new JavaMethodAreaOOM();
        a.instance = b;
        b.instance = a;
        a = null;
        b = null;
        // System.out.println(a.instance);
        System.gc();
    }
}
