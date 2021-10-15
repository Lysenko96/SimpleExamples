package gweep.net.allpatterns.creational.abstractfactory.car;

import gweep.net.allpatterns.creational.abstractfactory.Builder;

public class CarBuilder implements Builder {

	@Override
	public void build() {
		System.out.println(this.getClass().getSimpleName() + " build car project...");
	}
}