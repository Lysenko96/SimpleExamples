package net.gweep.threads;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MainExecutor {

	public static void main(String[] args) {
		ExecutorService service = Executors.newCachedThreadPool();
		ExecutorService serviceTwo = Executors.newFixedThreadPool(2);
		ExecutorService serviceOne = Executors.newSingleThreadExecutor();

		service.execute(new MyRunnable());
		serviceOne.execute(new MyRunnable());
		serviceTwo.execute(new MyRunnable());

		service.shutdown();
		serviceOne.shutdown();
		serviceTwo.shutdown();
	}
}
