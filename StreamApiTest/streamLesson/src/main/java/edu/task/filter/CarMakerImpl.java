package edu.task.filter;

import edu.task.behaviour.CarMaker;
import edu.task.entity.Car;

public class CarMakerImpl implements CarMaker {

	@Override
	public String makeCar(Car car) {
		return "model: " + car.getModel() + System.lineSeparator() + "speed: " + car.getSpeed();
	}

}
