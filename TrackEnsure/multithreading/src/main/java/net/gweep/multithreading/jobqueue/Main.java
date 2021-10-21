package net.gweep.multithreading.jobqueue;

public class Main {

	public static void main(String[] args) {
		JobQueue queue = new JobQueue();
		queue.put(new Runnable() {

			@Override
			public void run() {
				System.out.println("hello");
			}
		});
		queue.put(new Runnable() {

			@Override
			public void run() {
				System.out.println("world");
			}
		});

		new Thread(queue.getJob()).start();
		new Thread(queue.getJob()).start();

	}
}
