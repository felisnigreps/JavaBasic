package com.cat.misc.clone;

public class CloneTest {
    public static void main(String[] args) throws CloneNotSupportedException {
        Person a = new Person("jack",26);
        Teacher t = new Teacher("lu1");
        //浅克隆
        a.setTeacher(t);

        Person b = a.clone();
        Person c = a.clone();
        c.setTeacher(a.getTeacher().clone());
        System.out.println(a==b);
        //更改基本对象和引用对象
        a.setAge(22);
        t.setName("soft");
        //可以看到引用对象是一个
        System.out.println("a.age----"+a.getAge());
        System.out.println("b.age----"+b.getAge());
        System.out.println("a.teacherName----"+a.getTeacher().getName());
        System.out.println("b.teacherName----"+b.getTeacher().getName());

        //深克隆
        System.out.println("c.teacherName----"+c.getTeacher().getName());

    }
}
