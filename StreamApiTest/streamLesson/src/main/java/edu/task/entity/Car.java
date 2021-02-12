package edu.task.entity;

public class Car {

	private int speed;
	private String model;

	public Car() {
	}

	public Car(String model, int speed) {
		this.model = model;
		this.speed = speed;
	}

	public int getSpeed() {
		return speed;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

}
