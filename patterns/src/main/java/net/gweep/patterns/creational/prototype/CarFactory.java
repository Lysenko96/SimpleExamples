package net.gweep.patterns.creational.prototype;

public class CarFactory {

	private Car car;

	CarFactory(Car car) {
		setCar(car);
	}

	void setCar(Car car) {
		this.car = car;
	}

	Car makeCopy() {
		return (Car) car.copy();
	}
}
