package net.gweep.patterns.structural.facade;

public class Device {

	private String model;
	private int price;
	private Type type;

	Device(String model, int price, Type type) {
		this.model = model;
		this.price = price;
		this.type = type;
	}

	public String getModel() {
		return model;
	}

	public int getPrice() {
		return price;
	}

	public Type getType() {
		return type;
	}

	@Override
	public String toString() {
		return "Device [model=" + model + ", price=" + price + ", type=" + type + "]";
	}
}