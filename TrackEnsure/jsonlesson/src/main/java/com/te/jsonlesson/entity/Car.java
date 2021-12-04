package com.te.jsonlesson.entity;

import java.util.Objects;

public class Car {

	private int id;
	private String model;
	private int speed;
	
	public Car() {
	}

	public Car(int id, String model, int speed) {
		this.id = id;
		this.model = model;
		this.speed = speed;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public int getSpeed() {
		return speed;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, model, speed);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Car other = (Car) obj;
		return id == other.id && Objects.equals(model, other.model) && speed == other.speed;
	}

	@Override
	public String toString() {
		return "Car [id=" + id + ", model=" + model + ", speed=" + speed + "]";
	}
	
}