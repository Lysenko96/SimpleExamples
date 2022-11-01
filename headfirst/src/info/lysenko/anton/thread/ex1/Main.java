package info.lysenko.anton.thread.ex1;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {

    public static void main(String[] args) {
        ExecutorService exec = Executors.newFixedThreadPool(2);
        for(int i = 0; i < 5; i++)
            exec.execute(new MyRunnable(3));
        exec.shutdown();
    }
}

class MyRunnable implements Runnable {

    private int counter;

    public MyRunnable(){}

    public MyRunnable(int counter) {
        this.counter = counter;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName());
        for (int i = 0; i < counter; i++)
            System.out.println(i);
    }

    public int getCounter() {
        return counter;
    }

    public void setCounter(int counter) {
        this.counter = counter;
    }
}
