package net.gweep.threads3;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main implements Runnable {

	public static void main(String[] args) {

		System.out.println(args[0]);

		int count = Integer.parseInt(args[0]);
		ExecutorService service = Executors.newFixedThreadPool(count);
		for (int i = 0; i < count; i++) {
			service.execute(new Main());
		}
		service.shutdown();
	}

	@Override
	public void run() {
		try {
			int value = new Random().nextInt(10) + 1;
			TimeUnit.SECONDS.sleep(value);
			System.out.println(Thread.currentThread().getName() + " " + value);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		Thread.yield();
	}
}