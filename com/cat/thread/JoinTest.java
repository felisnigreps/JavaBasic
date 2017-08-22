package com.cat.thread;

public class JoinTest {
    static  class Fly implements Runnable {
        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Fly(String name){
            this.name = name;
        }

        private String name;

        @Override
        public void run() {
            for (int i = 0; i < 5; i++) {
                System.out.println("Rick first," + this.getName() + i);
            }

        }
    }


    public static void main(String[] args) throws InterruptedException {
        Thread rick = new Thread(new Fly("rick"));
        Thread morty = new Thread(new Fly("morty"));
        rick.start();
        //保证rick先执行完毕在执行morty
        rick.join();
        morty.start();

    }
}
