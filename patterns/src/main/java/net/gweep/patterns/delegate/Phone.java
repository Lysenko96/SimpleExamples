package net.gweep.patterns.delegate;

public class Phone implements Device {

	@Override
	public void show() {
		System.out.println("show display...");
	}
}