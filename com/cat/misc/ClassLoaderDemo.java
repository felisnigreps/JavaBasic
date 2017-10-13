package com.cat.misc;

import java.math.RoundingMode;

public class ClassLoaderDemo {
    public static void main(String[] args) {
        ClassLoader a = ClassLoaderDemo.class.getClassLoader();
        System.out.println(a);
        System.out.println(a.getParent());
        System.out.println(a.getParent().getParent());
        System.out.println(RoundingMode.CEILING);



    }
}
