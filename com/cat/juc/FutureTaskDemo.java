package com.cat.juc;

import java.util.concurrent.*;

/**
 * Created by xugenli on 2017/7/17.
 * <p>
 * java中有Future和FutureTask这两个类，他们区别是什么呢？
 * Future是一个接口，代表可以取消的任务，并可以获得任务的执行结果
 * FutureTask 是基本的实现了Future和runnable接口
 * 实现runnable接口，说明可以把FutureTask实例传入到Thread中，在一个新的线程中执行。
 * 实现Future接口，说明可以从FutureTask中通过get取到任务的返回结果，也可以取消任务执行（通过interreput中断）
 */
public class FutureTaskDemo {
    static class Task implements Callable<Integer> {
        @Override
        public Integer call() throws Exception {
            System.out.println("thread begins");
            int sum = 0;
            for (int i = 0; i < 101; i++) {
                sum += i;
            }
            return sum;
        }
    }

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();
        Task task = new Task();
        //  Future<Integer> future = executorService.submit(task);
        FutureTask<Integer> futureTask = new FutureTask<Integer>(task);
        executorService.submit(futureTask);
        executorService.shutdown();
        System.out.println("executing....");
        try {
            //  System.out.println("here is we got"+future.get());
            System.out.println("here is we got" + futureTask.get());

        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        System.out.println("finished");
        Thread.currentThread().getPriority();

    }

}
