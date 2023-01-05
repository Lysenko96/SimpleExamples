package info.lysenko.anton;

public class Main {

    public static void main(String[] args) {
        Thread t1 = new Thread(new MyRunnable());
        long start = System.currentTimeMillis();
        t1.start();
        try {
            t1.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        try {
            System.out.println(Thread.currentThread().getName());
            Thread.sleep(2000);
            System.out.println(1);
            System.out.println(Thread.currentThread().getName());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(System.currentTimeMillis() - start);
    }
}

class MyRunnable implements Runnable {
    @Override
    public void run() {
      //  long start = System.currentTimeMillis();
        try {
            System.out.println(Thread.currentThread().getName());
            Thread.sleep(2000);
            System.out.println(2);
            System.out.println(Thread.currentThread().getName());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
       // System.out.println(System.currentTimeMillis() - start);
    }
}
