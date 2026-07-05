package def;

import java.util.List;
import java.util.Objects;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.atomic.AtomicStampedReference;


public class A {

    private static List<Integer> i = new CopyOnWriteArrayList<>();
    private int idx = 0;


    public static void main(String[] args) {
        B b0 = new B("b");
        AtomicReference<B> b = new AtomicReference<>(b0);
//        AtomicReference<B> b = new AtomicReference<>();
        boolean success = false;
        while (!success) {
//            B b0 = new B("b");
//            b.set(b0);
            B oldB = b.get();
            B b1 = new B("b1");
            success = b.compareAndSet(oldB, b1);
        }
        System.out.println(b.get());
        Object o = new Object();
        AtomicStampedReference a = new AtomicStampedReference(o, 1);
        System.out.println("1");
        A aa = new A();
        Thread t = new Thread(() -> {
            for (int i = 0; i < 2; i++) {
                aa.put();
//                    try {
//                        Thread.sleep(5000);
//
//                    } catch (InterruptedException e) {
//                        throw new RuntimeException(e);
//                    }
            }
        });
        System.out.println("PUTPRIOR: " + t.getPriority());
        t.start();
        // InterruptedException
//        t.interrupt();
        // throw custom exception when interrupt
//    t.getUncaughtExceptionHandler().uncaughtException(t, new Exception("exc"));

            for (int p = 0; p < 4; p++) {
                aa.get();
            }
            Thread.currentThread().setPriority(Thread.MAX_PRIORITY);
        System.out.println("CURPRIOT: " + Thread.currentThread().getPriority());
        System.out.println("2");
        System.out.println("iiiiiiiii " + i);
        ForkJoinPool.commonPool().execute(()->{
            System.out.println("forkjoin");
            System.out.println(Thread.currentThread().getName());
        });
        Thread.currentThread().interrupt();
        System.out.println(Thread.currentThread().isInterrupted());
        System.out.println(Thread.interrupted()); // change status interrupted
        System.out.println(Thread.currentThread().isInterrupted()); // not changed status interrupted
        System.out.println(t.isInterrupted());
    }


    synchronized void get() {
        while (i.size() < 1) {
//        synchronized (A.class) {
            try {
                System.out.println("remove first wait: " + i);
                wait();
//                System.out.println(Thread.holdsLock(o));
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
//        int p = idx - 2;
//        System.out.println("clear idx " + p);
//        i.remove(p);
        i.remove(0);
        System.out.println("remove 0 " + i);
//        idx--;
        notify();
//        }
    }

    synchronized void put() {
        while (i.size() >= 2) {
            System.out.println("put wait:" + i);
            try {
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.println("add idx: " + idx + " " + (idx + 1) + " " + (idx + 2));
        i.add(idx++);
        i.add(idx++);
        i.add(idx++);
        System.out.println("add i" + i);
        notify();
    }
}

class B {

    private String s;

    public B() {
    }

    public B(String s) {
        this.s = s;
    }

    public String getS() {
        return s;
    }

    public void setS(String s) {
        this.s = s;
    }

    @Override
    public boolean equals(Object object) {
        if (object == null || getClass() != object.getClass()) return false;
        B b = (B) object;
        return Objects.equals(s, b.s);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(s);
    }

    @Override
    public String toString() {
        return "B{" +
                "s='" + s + '\'' +
                '}';
    }
}