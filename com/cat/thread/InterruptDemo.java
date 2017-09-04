package com.cat.thread;

public class InterruptDemo extends Thread {
/*    Thread.interrupt()方法不会中断一个正在运行的线程。这一方法实际上完成的是，
    在线程受到阻塞时抛出一个中断信号，这样线程就得以退出阻塞的状态。更确切的说，
    如果线程被Object.wait, Thread.join和Thread.sleep三种方法之一阻塞，
    那么，它将接收到一个中断异常（InterruptedException），从而提早地终结被阻塞状态 */
    boolean stop=false;
    public static void main( String args[] ) throws Exception {
        InterruptDemo thread = new InterruptDemo();
        System.out.println( "Starting thread..." );
        thread.start();
        Thread.sleep( 3000 );
        System.out.println( "Interrupting thread..." );
        thread.stop = true;

        // thread.interrupt();
        Thread.sleep( 3000 );
        System.out.println("Stopping application..." );
        //System.exit(0);
    }
    public void run() {
        while(!stop){
            System.out.println( "Thread is running..." );
            long time = System.currentTimeMillis();
            while((System.currentTimeMillis()-time < 1000)) {
            }
        }
        System.out.println("Thread exiting under request..." );
    }
}