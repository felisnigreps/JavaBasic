package com.cat.misc.clone;

public class Person implements Cloneable {
    //cloneable接口是一个标记接口 点进去发现什么都没有
    //如果不实现的话就会报错 但是,为什么要这么设计呢?
    //参见博文  www.tiltcat.com  面试题
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    String name;
    int age;

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    Teacher teacher;

    public Person clone() throws CloneNotSupportedException {
        Person clone = (Person) super.clone();
        return clone;
    }

}
