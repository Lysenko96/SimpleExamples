package net.gweep.multithreading.datamanager;

public class Main {

	public static void main(String[] args) {
		DataManager manager = new DataManager();
		manager.prepareData();
		manager.prepareData();
		manager.sendData();
	}
}
