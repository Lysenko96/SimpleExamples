package net.gweep.threads7;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Main {

	public static void main(String[] args) throws InterruptedException {
		ExecutorService service = Executors.newFixedThreadPool(2);

		final Counter counter = new Counter();
		Runnable task = () -> {
			for (int i = 1; i <= 1000; i++) {
				counter.increment();
			}
		};
		Runnable task1 = () -> {
			for (int i = 1; i <= 2000; i++) {
				counter.increment();
			}
		};
		service.submit(task);
		service.submit(task1);
		service.awaitTermination(3, TimeUnit.SECONDS);
		System.out.println(counter.getCount());
		service.shutdown();
	}
}

class Counter {

	private final Lock lock = new ReentrantLock();

	private int count = 0;

	// thread safe use lock counter = 3000
	// without use lock counter < 3000 because not atomic operation counter += 1
	void increment() {
		lock.lock();
		count += 1;
		lock.unlock();
	}

	int getCount() {
		return count;
	}
}