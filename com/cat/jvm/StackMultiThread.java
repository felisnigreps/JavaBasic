package com.cat.jvm;

/**
 * Created by gxu on 2016/12/1.
 */
public class StackMultiThread {
//执行此段代码会导致计算机假死

    //创建多个线程
    public void createThread(){
        for(;;){
            Thread t = new Thread(new Runnable() {
                @Override
                public void run() {
                  for(;;);
                }
            });
            t.start();
        }

    }
    public static void main(String[] args) {
        StackMultiThread thread = new StackMultiThread();
        thread.createThread();
    }
}
