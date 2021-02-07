package edu.task.behaviour;

import edu.task.entity.Car;

@FunctionalInterface
public interface Creatable {

	 void create(Car car);
}
