package net.gweep.threads6;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Main {

	public static void main(String[] args) throws InterruptedException {
		Resource resource = new Resource();
		resource.setI(4);
		resource.setJ(3);
		MyRunnable r = new MyRunnable();
		MyRunnable r2 = new MyRunnable();
		Thread t = new Thread(r);
		t.setName("one");
		r.setResource(resource);
		r2.setResource(resource);
		Thread t2 = new Thread(r2);
		t.start();
		t2.start();
		t.join();
		t2.join();
		System.out.println(resource.getI());
		System.out.println(resource.getJ());
	}

	static class MyRunnable implements Runnable {
		private Resource resource;

		@Override
		public void run() {
			resource.changeI();
		}

		Resource getResource() {
			return resource;
		}

		public void setResource(Resource resource) {
			this.resource = resource;
		}
	}
}

class Resource {
	private int i;
	private int j;

	// add synchronized for obj
	Lock lock = new ReentrantLock();

	void changeI() {
		lock.lock();
		int i = this.i;
		if (Thread.currentThread().getName().equals("one")) {
			Thread.yield();
		}
		i++;
		this.i = i;
		lock.unlock();
	}

	public int getJ() {
		return j;
	}

	public void setJ(int j) {
		this.j = j;
	}

	int getI() {
		return i;
	}

	void setI(int i) {
		this.i = i;
	}
}