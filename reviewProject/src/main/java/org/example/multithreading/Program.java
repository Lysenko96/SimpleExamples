package org.example.multithreading;

import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URI;
import java.nio.file.*;
import java.time.*;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAccessor;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Consumer;
import java.util.function.Supplier;
import java.util.stream.Stream;

public  class Program {

    volatile int i;
    public  static  void main(String[] args) throws ExecutionException, InterruptedException {

//        Semaphore sem = new Semaphore(2); // 2 permits
//        CommonResource res = new CommonResource();
//        new Thread(new CountThread(res, sem, "CountThread 1")).start();
//        new Thread(new CountThread(res, sem, "CountThread 2")).start();
//        new Thread(new CountThread(res, sem, "CountThread 3")).start();
//        FutureTask f = new FutureTask(null);
////        f.get();
////        f.run();
//        ExecutorService executorService = Executors.newFixedThreadPool(5);
//        Future future = executorService.submit(new CommonResource());
//        future.get();
//
//        Instant n = Instant.now().minus(1, ChronoUnit.HOURS);
//        Duration d1 = Duration.between(LocalDateTime.now(), LocalDateTime.now().minusDays(1));
//        Duration d = Duration.between(Instant.now(), n);
//        LocalDate.now();
//        LocalTime.now();
//        LocalDateTime.now();
//        ZonedDateTime z = ZonedDateTime.now();
//        ZoneId zId = z.getZone();
//        System.out.println(zId.getRules());
//        System.out.println(zId.getId());
        Stream s;
        File f = new File("/home/user/file.txt");
        try {
            Path p = Path.of("/home/user");
            p.getFileSystem().getFileStores().forEach(System.out::println);
            System.out.println(p.getNameCount());
            File fi = p.toFile();
//            Path result = Files.createFile(p);
//            Files.write(p, new byte[]{1,22,3,4,5,6,54,33}, StandardOpenOption.WRITE);
             System.out.println(Files.size(p));
        }catch (IOException e) {
            e.printStackTrace();
        }
        InputStream i;
        OutputStream o;
        Servlet s1;
//        System.out.println(p.getRoot());
//        System.out.println(p.getFileSystem().getFileStores());

    }
}

class MyServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }

}
class CommonResource implements Callable<Integer>{

    @Override
    public Integer call() throws Exception {
        return 5 + 1;
    }

    AtomicInteger x = new AtomicInteger(0);
}

class CountThread implements Runnable{

    CommonResource res;
    Semaphore sem;
    String name;
    CountThread(CommonResource res, Semaphore sem, String name){
        this.res=res;
        this.sem=sem;
        this.name=name;
    }

    public void run(){
//        synchronized (res) {
        try{
        System.out.println(name + " awaiting");
            sem.acquire();
            res.x = new AtomicInteger(1);
            for (int i = 1; i < 5; i++){
                res.x.getAndIncrement();
                System.out.println(this.name + ": " + res.x);
                Thread.sleep(100);
            }
        }
        catch(InterruptedException e){System.out.println(e.getMessage());}
        System.out.println(name + " releasing");
        sem.release();
//        }
    }

}