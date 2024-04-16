package org.example;

import org.junit.Assert;
import org.junit.Test;
import org.postgresql.Driver;

import java.sql.DriverManager;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ThreadLocalRandom;

class Main {

    static Random r = new Random();

    static boolean isPrime(int n) {
        for (int i = 2; i <= n / 2; i++) if (n % i == 0) return false;
        return true;
    }

     static String reverse(String str) {
       StringBuilder rever= new StringBuilder();
        for (int i = str.length()-1; i >=0; i--) {
            rever.append(str.charAt(i));
        }
        return rever.toString();

    }
//    List<Integer> list = new ArrayList<>();
    List<Integer> list = Collections.synchronizedList(new ArrayList<>());
    class MyThread implements Runnable {


        @Override
        public void run() {
//            System.out.println(Thread.currentThread().isDaemon());
//            Thread.currentThread().setDaemon(false);
//            System.out.println(Thread.currentThread() + ": " + ThreadLocal.withInitial(()->2).get());
//            System.out.println(Thread.currentThread().isDaemon());
            for(int i = 0; i < 1000; i++) {
                list.add(i);
//                System.out.println("Random: " + r.nextInt(15));
//                System.out.println("ThreadLocalRandom: " + ThreadLocalRandom.current().nextInt(15));
            }
            Iterator<Integer> it = list.iterator();
//            synchronized (list) {
                while (it.hasNext()) {
                    System.out.println(it.next());
                }
//            }
        }
    }
//    ConcurrentHashMap chm;
//    ArrayBlockingQueue abq;

    void show() {
            Thread t = new Thread(new MyThread());
//        Thread t1 = new Thread(new MyThread());
            Thread t1 = new Thread(() -> {
                list.remove(10);
            });
//        t.setDaemon(false);
//        t.setDaemon(false);
            t.start();
            t1.start();
//        System.out.println(t.isDaemon());
//        t.setDaemon(false);
            try {
                t.join();
                t1.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println(list);
    }
    public static void main(String[] args) {
        Main m = new Main();
        for(int i = 0; i < 10; i++) m.show();
        ThreadLocal<Integer> threadLocal = new ThreadLocal<>();
//        System.out.println(r.nextInt(10));
//        System.out.println(ThreadLocalRandom.current().nextInt(10));
//        System.out.println(Thread.currentThread() + ": " + ThreadLocal.withInitial(()->1).get());
//        System.out.println("Random: " + r.nextInt(10));
//        System.out.println("ThreadLocalRandom: " + ThreadLocalRandom.current().nextInt(10));
//        System.out.println(args.length);
//Optional<String> opt = Optional.ofNullable(null);
//        System.out.println(opt.isEmpty());
//        Deque d = new ArrayDeque();
       Calendar calendar = Calendar.getInstance(TimeZone.getDefault());
       TimeZone tz = TimeZone.getTimeZone(ZoneId.systemDefault());
        SimpleDateFormat sdf = new SimpleDateFormat();
        DateTimeFormatter f = DateTimeFormatter.ISO_DATE_TIME;
        LocalDateTime date = LocalDateTime.now();
        String text = date.format(f);
        Statement s;
//        System.out.println(text);
//        LocalDate parsedDate = LocalDate.parse(text, f);
//        System.out.println(parsedDate);
//        int t=1;
//        for (int i = 1; i <= args.length; i++) {
//            t*=i;
//        }
//        System.out.println(t);
//        Scanner in = new Scanner(System.in);
//        String x = in.next();

//        if (x == "Java") System.out.println("Hello");
//        else if (x == "java") System.out.println("hello");
//        else System.out.println("World");
//
//        Map<Student, Integer> map = new TreeMap<>(Comparator.comparing(Student::getLastname));
//        map.put(new Student("ba"), 1);
//        map.put(new Student("ab"), 1);
//        System.out.println(map);
//        System.out.println( isPrime(29));
//        int[] list = {2,4,7,10,11,45,50,59,60,66,69,70,79};
//        System.out.println(Arrays.binarySearch(list, 5));
//        System.out.println("30 cel eq " + ((9 / 5) * 30 + 32) + " far");
    }
//    @Test
//    public void re(){
//        Assert.assertEquals(null, Main.reverse(null));
//    }

}

//class Student {
//    String lastname;
//
//    public Student(String lastname) {
//        this.lastname = lastname;
//    }
//
//    public String getLastname() {
//        return lastname;
//    }
//
//    public void setLastname(String lastname) {
//        this.lastname = lastname;
//    }
//
//    @Override
//    public String toString() {
//        return "Student{" +
//                "lastname='" + lastname + '\'' +
//                '}';
//    }
//
//    //    @Override
////
////    public boolean equals(Object o) {
////        if (this == o) return true;
////        if (o == null || getClass() != o.getClass()) return false;
////        Student student = (Student) o;
////        return Objects.equals(lastname, student.lastname);
////    }
////
////    @Override
////    public int hashCode() {
////        return Objects.hash(lastname);
////    }
//    @Test
//    public void re(){
//        Assert.assertEquals(null, Main.reverse(null));
//    }
//}

