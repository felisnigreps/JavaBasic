package com.cat.misc;

/**
 * Created by xugenli on 2016/11/28.
 */
public class MultipleArguments {
    public static void main(String[] args) {
        out("Rick & Morty","wublubdubdub");
    }

    public static void out(String... input){
        for(String s:input){
            System.out.println(s);
        }
    }
}
