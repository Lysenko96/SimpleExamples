package net.gweep.multithreading.synch;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Counter {

	//private int count;

	//private Lock lock = new ReentrantLock();

	private AtomicInteger count = new AtomicInteger(0);

	public void increment() {
		count.incrementAndGet();
	}

	public int getValue() {
		return count.intValue();
	}

//	public void increment() {
//		lock.lock();
//		count++;
//		lock.unlock();
//	}
//
//	public int getValue() {
//		lock.lock();
//		int value = count;
//		lock.unlock();
//		return value;
//	}

//	public synchronized void increment() {
//		count++;
//	}
//
//	public synchronized int getValue() {
//		return count;
//	}
}
