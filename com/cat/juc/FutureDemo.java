package com.cat.juc;


import java.util.concurrent.*;

public class FutureDemo {
    public static void main(String[] args) {
        ExecutorService service = Executors.newFixedThreadPool(10);
        Future future = service.submit(new calculate());
        try {
            System.out.println(future.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }

    static class calculate implements Callable {
        @Override
        public Object call() throws Exception {
            int result = 0;
            for (int i = 0; i < 100; i++) {
                result += i;
            }
            return result;
        }
    }
}
