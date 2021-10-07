package gweep.net.allpatterns.creational.abstractfactory.car;

import gweep.net.allpatterns.creational.abstractfactory.Architector;

public class CarArchitector implements Architector {

	@Override
	public void structuring() {
		System.out.println(this.getClass().getSimpleName() + " structuring car project...");
	}
}