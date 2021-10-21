package net.gweep.multithreading.callable;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Main {

	public static void main(String[] args) {
		Callable<String> callable = new MyCallable();
		ExecutorService ex = Executors.newSingleThreadExecutor();
		Future<String> f = ex.submit(callable);

		try {
			String v = f.get();
			System.out.println(v);
		} catch (InterruptedException | ExecutionException e) {
			e.printStackTrace();
		}

		ex.shutdown();
	}
}