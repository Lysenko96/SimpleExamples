package net.gweep.threads2;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class MainExecutor {

	public static void main(String[] args) {
		ExecutorService service = Executors.newCachedThreadPool();
//		ExecutorService serviceTwo = Executors.newFixedThreadPool(2);
//		ExecutorService serviceOne = Executors.newSingleThreadExecutor();

		List<Future<Integer>> numbers = new ArrayList<>();
		numbers.add(service.submit(new Fibonacci(7)));
		numbers.add(service.submit(new Fibonacci(5)));
		for (Future<Integer> fi : numbers) {
			try {
				System.out.println(fi.get());
			} catch (InterruptedException | ExecutionException e) {
				e.printStackTrace();
			} finally {
				service.shutdown();
			}
		}

//		service.execute(new Fibonacci(5));
//		serviceOne.execute(new Fibonacci(5));
//		serviceTwo.execute(new Fibonacci(5));
//
//		service.shutdown();
//		serviceOne.shutdown();
//		serviceTwo.shutdown();
	}
}