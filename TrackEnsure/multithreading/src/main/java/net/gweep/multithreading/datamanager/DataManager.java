package net.gweep.multithreading.datamanager;

public class DataManager {

	private static Object monitor = new Object();
	int i;

	public void sendData() {
		synchronized (monitor) {
			System.out.println(i);
			try {
				while (i < 2) {
					monitor.wait();
				}
			} catch (InterruptedException e) {
				System.out.println("Sending data...");
			}

		}
	}

	public void prepareData() {
		synchronized (monitor) {
			System.out.println("Data is ready");
			monitor.notifyAll();
			i++;
		}
	}
}
