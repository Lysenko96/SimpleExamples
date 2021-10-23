package net.gweep.threads4;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class DaemonMain implements Runnable {

	public static void main(String[] args) {
		ExecutorService service = Executors.newSingleThreadExecutor(new DaemonThreadFactory(Thread.MAX_PRIORITY));
		ExecutorService serviceTwo = Executors.newSingleThreadExecutor(new DaemonThreadFactory(Thread.MIN_PRIORITY));

		for (int i = 0; i < 10; i++) {
			service.execute(new DaemonMain());
			serviceTwo.execute(new DaemonMain());
			System.out.println("All daemons started");
			try {
				// dependency time run program
				TimeUnit.MILLISECONDS.sleep(50);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public void run() {
		while (true) {
			try {
				// dependency count threads from time
				TimeUnit.MILLISECONDS.sleep(50);
				System.out.println(Thread.currentThread() + " " + this);
			} catch (InterruptedException e) {
				e.printStackTrace();
				System.out.println("Interrupted");
			}
		}
	}
}