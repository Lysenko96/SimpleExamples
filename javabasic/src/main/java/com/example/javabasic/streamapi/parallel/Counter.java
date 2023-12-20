package com.example.javabasic.streamapi.parallel;

import java.util.concurrent.atomic.AtomicLong;

public class Counter {

    private Long counter = 0L;
    private AtomicLong atomicLong = new AtomicLong(0);

    synchronized public void increment(){ // synchronized only 1 thread go to method and not conflict in multithreading
        counter++;
        //counter = atomicLong.incrementAndGet(); // atomic increment not conflict in multithreading
    }


    public Long getCounter() {
        return counter;
    }
}
