package com.cat.misc.generics;

public class Box<T> {
    public T getT() {
        return t;
    }

    public void setT(T t) {
        this.t = t;
    }

    private T t;

    public static void main(String[] args) {
        Box<String> a = new Box<>();
        Box<Boolean> b = new Box<>();
        Box<Integer> c = new Box<>();

    }
}
