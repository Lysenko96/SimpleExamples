package LessonsToInterview.MultithreadingTest;

public class MainMultithreadingTest {
    MainMultithreadingTest(){
        MyThread myThread = new MyThread();
        MyThread myThread1 = new MyThread();
        Thread thread = new Thread(myThread);
        thread.setPriority(Thread.MAX_PRIORITY);
        Thread thread1 = new Thread(myThread1);
        thread1.setPriority(Thread.MIN_PRIORITY);
        System.out.println(thread1.getName() + " " + thread1.getState());
        System.out.println(thread.getName() + " " + thread.getState());
        thread.start();
        thread1.start();
        try {
            thread.join();
            thread1.join();
            System.out.println(thread1.getName() + " " +  thread1.getState());
            System.out.println(thread.getName() + " " + thread.getState());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //System.out.println(Thread.currentThread().isInterrupted());
    }

    public static void main(String[] args) {
        new MainMultithreadingTest();
    }
}
class MyThread implements Runnable{
    @Override
    public synchronized void run() {
     //   System.out.println(Thread.currentThread().isInterrupted());
        System.out.println(Thread.currentThread() + " " + Thread.currentThread().getName());
        try {
            Thread.yield();
            Thread.sleep(1000);
       //     System.out.println(Thread.currentThread().isInterrupted());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } /*finally {
            Thread.currentThread().interrupt();
        }*/
        System.out.println(Thread.currentThread() + " " + Thread.currentThread().getName());
       // System.out.println(Thread.currentThread().isInterrupted());
        //Thread.interrupted();
        //System.out.println(Thread.currentThread().isInterrupted());
        System.out.println(Thread.currentThread().getName() + " " + Thread.currentThread().getState());
    }
}