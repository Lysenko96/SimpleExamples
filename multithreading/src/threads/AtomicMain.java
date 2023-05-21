package threads;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class AtomicMain {

    static int n = 0;
    static final AtomicInteger nA = new AtomicInteger(0);
    static final int NUM_THREADS = 100;
    static final int  NUM_INCREMENT = 100000;

    public static void main(String[] args) throws InterruptedException {

        ExecutorService executorService = Executors.newFixedThreadPool(10);
        //ExecutorService executorService = Executors.newFixedThreadPool(NUM_THREADS);

        for(int i = 0; i < NUM_THREADS; i++){
            executorService.execute(()-> {
                        for(int j = 0; j < NUM_INCREMENT; j++){
                       //n++;
                       nA.incrementAndGet();
               }
            });
//            Thread thread = new Thread(() -> {
//               for(int j = 0; j < NUM_INCREMENT; j++){
//                       n++;
//                      // nA.incrementAndGet();
//               }
//            });
//            thread.start();
//            try {
//                thread.join();
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
        }
        executorService.shutdown();
        // main thread wait work all another threads
        System.out.println(executorService.awaitTermination(1, TimeUnit.MINUTES));
        System.out.println(nA);
    }
}
