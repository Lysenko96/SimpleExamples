package edu.lysenko.patterns.creational.factorymethod;

public class RoadSchedule extends Schedule {

	@Override
	Receivable getType() {
		return new RoadReceive();
	}

}
