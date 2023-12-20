package com.example.javabasic.streamapi.parallel;

public class ThreadMain {

    public static void main(String[] args) {
        Counter counter = new Counter();
        Runnable increment = () -> {
            for (int i = 0; i < 10_000; i++) {
                counter.increment();
            }
        };
        Thread t = new Thread(increment);
        Thread t2 = new Thread(increment);
        t.start();
        t2.start();
        try {
            t.join();
            t2.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println(counter.getCounter());
    }
}
