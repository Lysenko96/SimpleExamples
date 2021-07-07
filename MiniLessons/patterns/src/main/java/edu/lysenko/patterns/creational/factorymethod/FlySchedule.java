package edu.lysenko.patterns.creational.factorymethod;

public class FlySchedule extends Schedule {

	@Override
	Receivable getType() {
		return new FlyReceive();
	}
}
