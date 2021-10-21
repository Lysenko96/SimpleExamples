package net.gweep.multithreading.jobqueue;

import java.util.ArrayList;
import java.util.List;

public class JobQueue {

	List<Runnable> jobs = new ArrayList<>();

	public synchronized void put(Runnable job) {
		jobs.add(job);
		this.notifyAll();
	}

	public synchronized Runnable getJob() {
		while (jobs.size() == 0) {
			try {
				this.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		return jobs.remove(0);
	}
}
