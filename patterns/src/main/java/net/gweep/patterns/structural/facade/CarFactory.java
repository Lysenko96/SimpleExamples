package net.gweep.patterns.structural.facade;

import java.util.Arrays;

public class CarFactory {

	public Car assembly(Device... devices) {
		return new Car(Arrays.asList(devices));
	}
}
