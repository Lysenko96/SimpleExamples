package net.gweep.threads4;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main implements Runnable {

	private int countDown = 5;
	private volatile double d;
	private int priority;

	Main(int priority) {
		this.priority = priority;
	}

	@Override
	public String toString() {
		return Thread.currentThread() + " [countDown=" + countDown + "]";
	}

	public static void main(String[] args) {

		ExecutorService service = Executors.newCachedThreadPool();
		for (int i = 0; i < 5; i++) {
			service.execute(new Main(Thread.MIN_PRIORITY));
		}
		service.execute(new Main(Thread.MAX_PRIORITY));
		service.shutdown();
	}

	@Override
	public void run() {
		Thread.currentThread().setPriority(priority);
		while (true) {
			for (int i = 1; i < 100_000; i++) {
				d += (Math.PI + Math.E) / i;
				if (i % 1000 == 0) {
					Thread.yield();
				}
			}
			System.out.println(this);
			if (--countDown == 0) {
				return;
			}
		}
	}
}