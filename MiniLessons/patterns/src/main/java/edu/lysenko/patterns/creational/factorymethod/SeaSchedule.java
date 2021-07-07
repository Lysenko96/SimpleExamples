package edu.lysenko.patterns.creational.factorymethod;

public class SeaSchedule extends Schedule {

	@Override
	Receivable getType() {
		return new SeaReceive();
	}
}
