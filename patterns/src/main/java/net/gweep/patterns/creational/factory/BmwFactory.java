package net.gweep.patterns.creational.factory;

public class BmwFactory implements CarFactory{

	@Override
	public Car getCar() {
		return new Bmw();
	}

	
}
