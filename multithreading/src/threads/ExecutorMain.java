package threads;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorMain {

    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(10);
        for(int i = 0; i < 15; i++) {
            executor.execute(() -> {
                System.out.println(Thread.currentThread().getName() + " hello");
            });
        }
        executor.shutdown();
    }
}
