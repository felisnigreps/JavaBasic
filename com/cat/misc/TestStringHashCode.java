package com.cat.misc;

import java.lang.reflect.Field;

/**
 * Created by xugenli on 2017/7/17.
 */
public class TestStringHashCode {
    //what happened to the hashcode of an String if I use reflect to change the value of the String?
    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {
        String a = "abc";
        System.out.println("original hashcode of abc = " + a.hashCode());
        Field fieldOfString = String.class.getDeclaredField("value");
        fieldOfString.setAccessible(true);
        char[] after = (char[]) fieldOfString.get(a);
        System.out.print("the value we got from reflect is" + after + ", value = ");
        System.out.println(after);
        after[2] = 'Q';
        System.out.println("change 'c' to 'Q',then a = " + a);
        System.out.println("does the hashcode changed? a.hashcode = " + a.hashCode());
        System.out.println("abQ's hashcode = " + "abQ".hashCode());
        //fun is start from here~
        System.out.println(a == "abc");
        System.out.println("abc".charAt(2));

        //we can change the hashcode to make two different String return true when we use '=='
        //but this only work in same object,in this case the second "abc",which shows as a arg in sout
        //JVM will calculate the hashcode of "abc" and search "runtime constant pool" to see if it exits
        //it will recognize "abQ"(changed from "abc" but still have same hashcode) as "abc" then return true.
        //hashcode will not re-generated when I change the value of an String
    }
}
