package edu.lysenko.lesson.multithreading;

public class MainMultithreading extends Thread implements Runnable {

	public static void main(String[] args) {

		Runtime.getRuntime().addShutdownHook(new MainMultithreading());

		try {

			Thread.sleep(2000);
			MainMultithreading multithreading = new MainMultithreading();
			// multithreading.start(); thread - dead java.lang.IllegalThreadStateException
			MainMultithreading multithreading2 = new MainMultithreading();
			new MainMultithreading().startThreads(multithreading, multithreading2);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	synchronized void startThreads(MainMultithreading multithreading, MainMultithreading multithreading2) {
		// multithreading.start(); thread - dead java.lang.IllegalThreadStateException
		multithreading.run();
		multithreading2.run();
		multithreading.setDaemon(true);
		System.out.println(multithreading.isDaemon());
		System.out.println(multithreading2.isDaemon());
		synchronized (this) {
			multithreading.start();
		}
		// multithreading.setDaemon(true); daemon thread don't assign after start
		multithreading2.start();
		System.out.println(Thread.currentThread().getName());
		MainMultithreading multithreading3 = new MainMultithreading();
		Thread thread = new Thread(multithreading3);
		thread.start();
	}

	@Override
	public void run() {
		System.out.println(Thread.currentThread().getName());
		System.out.println("addShutdownHook()");
	}

}
