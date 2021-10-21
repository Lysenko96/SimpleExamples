package net.gweep.multithreading.synch;

public class IncrementerThread extends Thread {

	private Counter counter;

	public IncrementerThread(Counter counter) {
		this.counter = counter;
	}

	public static void runExperiment(Counter counter) throws Exception {
		Thread t1 = new IncrementerThread(counter);
		Thread t2 = new IncrementerThread(counter);
		long start = System.currentTimeMillis();
		t1.start();
		t2.start();
		t1.join();
		t2.join();
		long end = System.currentTimeMillis() - start;
		System.out.println("counter= " + counter.getValue() + ", time (ms)= " + end);
	}

	@Override
	public void run() {
		for (int i = 0; i < 100_000_000; i++) {
			counter.increment();
		}
	}

}