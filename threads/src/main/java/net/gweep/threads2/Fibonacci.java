package net.gweep.threads2;

import java.util.concurrent.Callable;

public class Fibonacci implements Callable<Integer> {

	private int n;

	Fibonacci(int n) {
		this.n = n;
	}

	@Override
	public Integer call() {
		int result = 0;
		for (int i = 0; i < n; i++) {
			System.out.println(Thread.currentThread().getName() + " " + fib(i));
			result += fib(i);
		}
		Thread.yield();
		System.out.println("finished");
		return result;
	}

	private int fib(int value) {
		if (value < 2)
			return 1;
		return fib(value - 2) + fib(value - 1);
	}
}