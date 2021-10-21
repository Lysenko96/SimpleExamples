package net.gweep.multithreading.deadlock;

public class DeadlockRisk {

	private static class Resource {
		public double value;
	}

	private Resource resourceA = new Resource();
	private Resource resourceB = new Resource();

	public double read() {
		synchronized (resourceA) {
			synchronized (resourceB) {
				return resourceA.value + resourceB.value;
			}
		}
	}

	public void write(double a, double b) {
		synchronized (resourceB) {
			synchronized (resourceA) {
				resourceA.value = a;
				resourceB.value = b;
			}

		}
	}

}
