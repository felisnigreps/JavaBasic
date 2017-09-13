package com.cat.misc.clone;

public class Teacher implements Cloneable {
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Teacher(String name) {
        this.name = name;
    }

    private String name;


    public Teacher clone() throws CloneNotSupportedException {
        Teacher clone = (Teacher) super.clone();
        return clone;
    }
}
