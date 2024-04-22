package org.example.threadreview;

import java.util.concurrent.*;

public class Main {

//    static ScheduledExecutorService scheduledExecutorService;
//    static ScheduledFuture<?> scheduledFuture;

    public static void main(String[] args) {
        Executor executor;
        ExecutorService executorService;
        Executors executors;
        ExecutorService service = Executors.newFixedThreadPool(2);
        Executors.newCachedThreadPool();
        Long id = 1L;
        Callable<Long> call = Executors.callable(() -> System.out.println("call"), id);
        FutureTask<Long> futureTask = new FutureTask<>(new MyCallable());
        FutureTask<Long> futureTask1 = new FutureTask<>(new MyRunnable(), null);
        FutureTask<Long> futureTask2 = new FutureTask<>(new MyRunnable(), null);
        futureTask.cancel(true);

//        for (int i = 0; i < 4; i++) {
//            Thread myThread = new Thread(futureTask);
//            Thread myThread1 = new Thread(futureTask1);
////            Future<Long> future = service.submit(new MyCallable());
////            Future<?> future1 = service.submit(new MyRunnable());
////            Future<?> future2 = service.submit(new MyRunnable());
//            myThread.start();
//            myThread1.start();
//            try {
//                futureTask.get();
////            System.out.println(futureTask.get());
////            System.out.println(futureTask1.get());
////                System.out.println(future.get());
////                System.out.println(future1.get());
////                System.out.println(future2.get());
//            } catch (InterruptedException | ExecutionException e) {
//                throw new RuntimeException(e);
//            }
//        }
       ScheduledExecutorService  scheduledExecutorService = Executors.newSingleThreadScheduledExecutor();
//        scheduledExecutorService.schedule(new MyRunnable(), 3, TimeUnit.SECONDS);
        Runnable runnable = () -> System.out.println("run");
        executor = (r) -> new Thread(r).start();
//        executor = (r) -> new Thread(new FutureTask<>(new MyCallable())).start();
        executor.execute(runnable);
        RunnableFuture<Long> runnable1 = new FutureTask<>(new MyCallable());
        executor.execute(runnable1);
        try {
            System.out.println(runnable1.get());
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
//        ScheduledFuture<?> scheduledFuture = scheduledExecutorService.scheduleAtFixedRate(runnable, 2, 3, TimeUnit.SECONDS);
//        try {
//            scheduledFuture.get(6, TimeUnit.SECONDS);
//        } catch (InterruptedException | ExecutionException | TimeoutException e) {
//            scheduledExecutorService.shutdown();
//        }


//        try {
//            scheduledFuture.get();
//        } catch (InterruptedException | ExecutionException e) {
//            throw new RuntimeException(e);
//        }
//            scheduledExecutorService.shutdown();
        ThreadFactory factory = Executors.defaultThreadFactory();
        scheduledExecutorService.shutdown();
        service.shutdown();
    }

    static class MyRunnable implements Runnable {
        @Override
        public void run() {
            System.out.println("run");
            System.out.println(Thread.currentThread().getName());

//            scheduledFuture.cancel(false);
//            try {
//                Thread.sleep(2000);
////                scheduledFuture.cancel(false);
////                scheduledExecutorService.shutdown();
//            } catch (InterruptedException e) {
//                throw new RuntimeException(e);
//            }
        }
    }

    static class MyCallable implements Callable<Long> {
        @Override
        public Long call() throws Exception {
            Long j = 0L;
            for (int i = 0; i < 3; i++) {
                j++;
                Thread.sleep(100);
            }
//            System.out.println(Thread.currentThread().getName());
//            System.out.println(j);
            return j;
        }
    }
}
