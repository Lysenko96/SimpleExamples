package net.gweep.patterns.creational.factory;

public class TeslaFactory implements CarFactory {

	@Override
	public Car getCar() {
		return new Tesla();
	}
}