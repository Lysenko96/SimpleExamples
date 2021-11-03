package net.gweep.patterns.delegate;

public class Tv implements Device {

	@Override
	public void show() {
		System.out.println("show monitor...");
	}
}