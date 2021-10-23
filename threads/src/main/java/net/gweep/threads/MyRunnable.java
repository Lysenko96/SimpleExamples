package net.gweep.threads;

public class MyRunnable implements Runnable {

	MyRunnable() {
		System.out.println("init");
	}

	@Override
	public void run() {
		for (int i = 0; i < 2; i++) {
			System.out.println(Thread.currentThread().getName() + " message[" + i + "]");
			Thread.yield();
		}
		System.out.println("finished");
	}

}