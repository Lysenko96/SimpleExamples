package gweep.net.allpatterns.creational.abstractfactory;

import gweep.net.allpatterns.creational.abstractfactory.car.CarTeamFactory;

public class Tesla {

	void createTesla() {
		ProjectTeamFactory teamFactory = new CarTeamFactory();
		Architector architector = teamFactory.getArchitector();
		Builder builder = teamFactory.getBuilder();
		System.out.println("Creating tesla project...");
		architector.structuring();
		builder.build();
	}
}