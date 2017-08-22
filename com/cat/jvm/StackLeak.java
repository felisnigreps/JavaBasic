package com.cat.jvm;

public class StackLeak {
    int threadLength = 1;

    private void leakTest() {
        threadLength++;
        leakTest();
    }

    public static void main(String[] args) throws Throwable {
        StackLeak leak = new StackLeak();
        try {
            leak.leakTest();
        } catch (Throwable e) {
            System.out.println("Thread length is " + leak.threadLength);
            throw e;
        }
    }
}
