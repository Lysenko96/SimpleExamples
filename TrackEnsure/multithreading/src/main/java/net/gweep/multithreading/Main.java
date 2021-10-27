package net.gweep.multithreading;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class Main {

	private double result;
	private int finished;

	ReentrantLock lock = new ReentrantLock();
	Condition condition = lock.newCondition();

	public static void main(String[] args) {

		Main main = new Main();
		// main.run();
		main.run1();

	}

	private void run1() {
		double a = 0;
		double b = Math.PI;
		int n = 1000_000_000;
		int nThreads = 50;
		long start = System.currentTimeMillis();
		double delta = (b - a) / nThreads;
		for (int i = 0; i < nThreads; i++) {
			ThreadingIntegralCalc calcThread = new ThreadingIntegralCalc(a + i * delta, a + (i + 1) * delta,
					n / nThreads, Math::sin, this);
			new Thread(calcThread).start();
		}
		lock.lock();
		try {
			while (finished < nThreads) {
				condition.await();
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			lock.unlock();
		}
		long end = System.currentTimeMillis();
		System.out.println(result);
		System.out.println(end - start);
	}

	public synchronized void sendResult1(double result) {
		lock.lock();
		try {
			this.result += result;
			finished++;
			condition.signalAll();
		} finally {
			lock.unlock();
		}
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
