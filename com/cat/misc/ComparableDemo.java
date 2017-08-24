package com.cat.misc;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ComparableDemo {
    //内部的比较排序
    static class Person implements Comparable<Person> {
        int age;
        String name;

        public Person(int age, String name) {
            this.age = age;
            this.name = name;
        }

        @Override
        public int compareTo(Person o) {
            //  return this.age - o.age;
            return o.age - this.age;

        }

        public String toString() {

            return name + ":" + age;
        }
    }

    //比较明了
    public static void main(String[] args) {
        Person a = new Person(12, "Jim");
        Person b = new Person(22, "Bob");
        Person c = new Person(17, "Lisa");
        List<Person> list = new ArrayList<>();
        list.add(a);
        list.add(b);
        list.add(c);
        System.out.println(list);
        Collections.sort(list);
        System.out.println(list);

    }
}
