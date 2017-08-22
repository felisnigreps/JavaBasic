package com.cat.jvm;

/**
 * Created by gxu on 2016/12/1.
 */
public class StringInternTest {
    public static void main(String[] args) {
        String a =new StringBuilder("ja").append("va").toString();
        System.out.println(a.intern()==a);
        //常量池中不存在，intern创建字符串对象并返回它的引用(java 堆中)
        String b = new StringBuilder("计算机").append("科学").toString();
        System.out.println(b.intern()==b);

    }
}
