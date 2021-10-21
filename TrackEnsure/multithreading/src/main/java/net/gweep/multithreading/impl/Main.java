package net.gweep.multithreading.impl;

public class Main {

	public static void main(String[] args) {
		new MyThread().start();
		new Thread(new MyRunnable()).start();
	}
}
