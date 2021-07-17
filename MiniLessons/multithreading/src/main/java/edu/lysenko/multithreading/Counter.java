package edu.lysenko.multithreading;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Counter implements Callable<Integer> {

	private int number;
	private int sum;

	Counter() {

	}

	Counter(int number) throws Exception {
		this.number = number;
		this.sum = call();
	}

	int method(int n) {
		int result = 1;
		for (int i = 0; i < n; i++) {
			result *= i + 1;
		}
		return result;
	}

	public Integer call() throws Exception {
		Thread.yield();
		System.out.println(Thread.currentThread().getName());
		return method(number);
	}

	public int getSum() {
		return sum;
	}

	public static void main(String[] args) throws Exception {
		Counter c = new Counter(11);
		ExecutorService executor = Executors.newFixedThreadPool(2);
		Future<Integer> future = executor.submit(c);
		System.out.println(future.get());
		executor.shutdown();
	}

}
