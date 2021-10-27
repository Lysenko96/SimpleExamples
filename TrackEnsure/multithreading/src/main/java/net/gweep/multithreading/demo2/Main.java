package net.gweep.multithreading.demo2;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Main {

	int counter;

	public static void main(String[] args) {
		Main main = new Main();
		main.run();
	}

	private void run() {
		ScheduledExecutorService service = Executors.newScheduledThreadPool(25);
		// service.schedule(()-> "call", 3, TimeUnit.SECONDS);
		try {
			System.out.println(service.schedule(() -> "calling...", 1, TimeUnit.SECONDS).get());
			System.out.println(service
					.scheduleAtFixedRate(() -> System.out.println("string " + ++counter), 2l, 3l, TimeUnit.SECONDS)
					.get());
		} catch (ExecutionException | InterruptedException e) {
			e.printStackTrace();
		} finally {
			service.shutdown();
		}
	}
}
