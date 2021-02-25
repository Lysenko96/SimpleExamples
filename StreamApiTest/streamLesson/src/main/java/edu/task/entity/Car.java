package edu.task.entity;

public class Car {

	private Float speed;
	private String model;

	public Car() {
	}

	public Car(String model, Float speed) {
		this.model = model;
		this.speed = speed;
	}

	public Float getSpeed() {
		return speed;
	}

	public void setSpeed(Float speed) {
		this.speed = speed;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	@Override
	public String toString() {
		return "Car [speed=" + speed + ", model=" + model + "]";
	}

}
