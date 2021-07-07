package edu.lysenko.patterns.creational.factorymethod;

import java.util.Random;

public class FactoryMethodMain {

	public static void main(String[] args) {
		Schedule[] schedule = new Schedule[] { new SeaSchedule(), new RoadSchedule(), new FlySchedule() };
		for (int i = 0; i < 5; i++) {
			System.out.println(schedule[new Random().nextInt(3)].getType().receive());
		}
	}
}
