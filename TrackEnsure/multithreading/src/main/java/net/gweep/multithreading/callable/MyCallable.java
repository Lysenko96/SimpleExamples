package net.gweep.multithreading.callable;

import java.util.concurrent.Callable;

public class MyCallable implements Callable<String> {

	@Override
	public String call() throws Exception {
		StringBuilder sb = new StringBuilder("hello");
		sb.reverse();
		return sb.toString();
	}
}