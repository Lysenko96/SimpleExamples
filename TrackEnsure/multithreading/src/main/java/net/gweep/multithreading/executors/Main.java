package net.gweep.multithreading.executors;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;
import java.util.stream.Collectors;

public class Main {

	private double result;
	private int finished;

	ReentrantLock lock = new ReentrantLock();
	Condition condition = lock.newCondition();

	public static void main(String[] args) {

		Main main = new Main();
		// main.run();
		// main.run1();
		// main.run2();
		main.run3();
	}

//	private void run1() {
//		double a = 0;
//		double b = Math.PI;
//		int n = 1000_000_000;
//		int nThreads = 50;
//		long start = System.currentTimeMillis();
//		double delta = (b - a) / nThreads;
//		for (int i = 0; i < nThreads; i++) {
//			ThreadingIntegralCalc calcThread = new ThreadingIntegralCalc(a + i * delta, a + (i + 1) * delta,
//					n / nThreads, Math::sin, this);
//			new Thread(calcThread).start();
//		}
//		lock.lock();
//		try {
//			while (finished < nThreads) {
//				condition.await();
//			}
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		} finally {
//			lock.unlock();
//		}
//		long end = System.currentTimeMillis();
//		System.out.println(result);
//		System.out.println(end - start);
//	}

	private void run2() {
		double a = 0;
		double b = Math.PI;
		int n = 1000_000_000;
		int nThreads = 5000;
		long start = System.currentTimeMillis();
		double delta = (b - a) / nThreads;
		List<Future<Double>> futures = new ArrayList<>();

		ExecutorService service = Executors.newFixedThreadPool(5000);
		for (int i = 0; i < nThreads; i++) {
			Future<Double> future = service.submit(
					new CallableIntegralCalc(a + i * delta, a + (i + 1) * delta, n / nThreads, Math::sin, this));
			futures.add(future);
		}
		try {
			for (Future<Double> future : futures) {
				result += future.get();
			}
		} catch (InterruptedException | ExecutionException e) {
			e.printStackTrace();
		} finally {
			service.shutdown();
		}
		long end = System.currentTimeMillis();
		System.out.println(result);
		System.out.println(end - start);
	}

	private void run3() {
		double a = 0;
		double b = Math.PI;
		int n = 1000_000_000;
		int nThreads = 100;
		long start = System.currentTimeMillis();
		double delta = (b - a) / nThreads;

		List<Callable<Double>> callables = new ArrayList<>();
		ExecutorService service = Executors.newWorkStealingPool();

		for (int i = 0; i < nThreads; i++) {
			callables.add(new CallableIntegralCalc(a + i * delta, a + (i + 1) * delta, n / nThreads, Math::sin, this));

		}

		try {
			result = service.invokeAll(callables).stream().map(f -> {
				Double d = 0d;
				try {
					d = f.get();
				} catch (ExecutionException | InterruptedException e) {
					e.printStackTrace();
				}
				return d;
			}).mapToDouble(x -> x).sum();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		long end = System.currentTimeMillis();
		System.out.println(result);
		System.out.println(end - start);
	}

	public synchronized Double sendResult2(double result) {
		lock.lock();
		try {
			this.result += result;
			finished++;
			condition.signalAll();
		} finally {
			lock.unlock();
		}
		return this.result;
	}

	public synchronized Double sendResult1(double result) {
		lock.lock();
		try {
			this.result += result;
			finished++;
			condition.signalAll();
		} finally {
			lock.unlock();
		}
		return this.result;
	}

//	private void run() {
//		double a = 0;
//		double b = Math.PI;
//		int n = 1000_000_000;
//		int nThreads = 50;
//		long start = System.currentTimeMillis();
////		IntegralCalculator c = new IntegralCalculator(a, b, n, Math::sin);
////		result = c.calculate();
//
//		double delta = (b - a) / nThreads;
//		for (int i = 0; i < nThreads; i++) {
//			ThreadingIntegralCalc calcThread = new ThreadingIntegralCalc(a + i * delta, a + (i + 1) * delta,
//					n / nThreads, Math::sin, this);
//			new Thread(calcThread).start();
//		}
//
//		try {
//			synchronized (this) {
//				while (finished < nThreads) {
//					wait();
//				}
//			}
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		}
//
//		long end = System.currentTimeMillis();
//		System.out.println(result);
//		System.out.println(end - start);
//	}

	public synchronized void sendResult(double result) {
		this.result += result;
		finished++;
		notify();
	}
}
