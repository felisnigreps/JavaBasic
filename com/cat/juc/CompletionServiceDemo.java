package com.cat.juc;

import java.util.concurrent.*;

public class CompletionServiceDemo {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        ExecutorService service = Executors.newCachedThreadPool();
        CompletionService<Integer> completion = new ExecutorCompletionService<>(service);
        for (int i = 0; i < 10; i++) {
            int finalI = i;
            completion.submit(() -> finalI);
        }
        for (int i = 0; i < 10; i++) {
            System.out.println(completion.take().get());
        }
        service.shutdown();
    }

}