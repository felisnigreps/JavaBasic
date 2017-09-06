package com.cat.misc;

public class ClassLoaderDemo {
    public static void main(String[] args) {
        ClassLoader a = ClassLoaderDemo.class.getClassLoader();
        System.out.println(a);
        System.out.println(a.getParent());
        System.out.println(a.getParent().getParent());
    }
}
