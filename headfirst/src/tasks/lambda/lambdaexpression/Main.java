package tasks.lambda.lambdaexpression;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Main {

    public static void main(String[] args) {

    }

    public String getThreadName() throws Exception {
        ExecutorService service = Executors.newCachedThreadPool();
        Future<String> threadName = service.submit(new Callable<String>() {
            @Override
            public String call() { return Thread.currentThread().getName(); }
        });
        return threadName.get();
    }

    public String getThreadNameLambda() throws Exception {
        ExecutorService service = Executors.newCachedThreadPool();
        Future<String> threadName = service.submit(() -> Thread.currentThread().getName());
        return threadName.get();
    }
}
