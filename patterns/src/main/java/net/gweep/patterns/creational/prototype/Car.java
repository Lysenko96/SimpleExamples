package net.gweep.patterns.creational.prototype;

public class Car implements Copyable {

	private String model;
	private int speed;
	private int price;

	Car(String model, int speed, int price) {
		this.model = model;
		this.speed = speed;
		this.price = price;
	}

	@Override
	public Object copy() {
		Car copy = new Car(model, speed, price);
		return copy;
	}

	@Override
	public String toString() {
		return "Car [model=" + model + ", speed=" + speed + ", price=" + price + "]";
	}
}