package com.cat.misc.generics;

public class Pair<K, V> {
    public Pair(K key, V value) {
        this.key = key;
        this.value = value;
    }

    private K key;
    private V value;

    public K getKey() {
        return key;
    }

    public void setKey(K key) {
        this.key = key;
    }

    public V getValue() {
        return value;
    }

    public void setValue(V value) {
        this.value = value;
    }

    public static boolean compare(Pair p1, Pair p2) {
        return p1.getKey().equals(p2.getKey()) && p1.getValue().equals(p2.getValue());
    }

    public static void main(String[] args) {
        Pair a = new Pair(1,2);
        Pair b = new Pair(1,2);
        System.out.println(compare(a,b));
    }

}
