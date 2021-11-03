package net.gweep.patterns.structural.facade;

import java.util.List;

public class Car {

	private List<Device> devices;

	Car(List<Device> devices) {
		this.devices = devices;
	}

	public List<Device> getDevices() {
		return devices;
	}

	@Override
	public String toString() {
		return "Car [devices=" + devices + "]";
	}
}