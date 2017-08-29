package com.cat.misc;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ComparatorDemo {
    //外部的排序
    //内部的比较排序
    static class Person {
        int age;
        String name;

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Person(int age, String name) {
            this.age = age;
            this.name = name;
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

        //顺序的话可以采用comparingInt方法
        // Collections.sort(list,(Comparator.comparingInt(o -> o.age)));

        //同样是逆序
        //Collections.sort(list,((o1, o2) -> o2.age-o1.age));

        //可以通过这么定义来调用reversed方法来实现逆序
        Comparator<Person> comparator = Comparator.comparingInt(Person::getAge);
        Collections.sort(list, comparator.reversed());
        System.out.println(list);

        System.out.println(Integer.toString(2));
    }


}
