package net.gweep.multithreading;

public class Main {

	private double result;
	private int finished;

	public static void main(String[] args) {

		Main main = new Main();
		main.run();

	}

	private void run() {
		double a = 0;
		double b = Math.PI;
		int n = 1000_000_000;
		int nThreads = 50;
		long start = System.currentTimeMillis();
//		IntegralCalculator c = new IntegralCalculator(a, b, n, Math::sin);
//		result = c.calculate();

		double delta = (b - a) / nThreads;
		for (int i = 0; i < nThreads; i++) {
			ThreadingIntegralCalc calcThread = new ThreadingIntegralCalc(a + i * delta, a + (i + 1) * delta,
					n / nThreads, Math::sin, this);
			new Thread(calcThread).start();
		}

		try {
			synchronized (this) {
				while (finished < nThreads) {
					wait();
				}
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		long end = System.currentTimeMillis();
		System.out.println(result);
		System.out.println(end - start);
	}

	public synchronized void sendResult(double result) {
		this.result += result;
		finished++;
		notify();
	}
}
