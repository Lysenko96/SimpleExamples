package com.example.javabasic.streamapi.parallel;

public class Deadlock {

    public static void main(String[] args) {
        Counter c1 = new Counter();
        Counter c2 = new Counter();
        Runnable r1 = () -> {
            synchronized (c1) {
                try {
                    Thread.sleep(1000L);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                c2.increment();
            }
        };
        Runnable r2 = () -> {
            synchronized (c2) {
                c1.increment();
            }
        };
        Thread t1 = new Thread(r1);
        Thread t2 = new Thread(r2);
        Thread t3 = new Thread(() -> {
            while (true) {
                System.out.println(t1.getName() + ": " + t1.getState());
                System.out.println(t2.getName() + ": " + t2.getState());
                try {
                    Thread.sleep(1000L);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });
        t3.start();
        t1.start();
        t2.start();
        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
