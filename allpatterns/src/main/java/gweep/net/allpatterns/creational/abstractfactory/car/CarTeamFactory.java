package gweep.net.allpatterns.creational.abstractfactory.car;

import gweep.net.allpatterns.creational.abstractfactory.Architector;
import gweep.net.allpatterns.creational.abstractfactory.Builder;
import gweep.net.allpatterns.creational.abstractfactory.ProjectTeamFactory;

public class CarTeamFactory implements ProjectTeamFactory {

	@Override
	public Architector getArchitector() {
		return new CarArchitector();
	}

	@Override
	public Builder getBuilder() {
		return new CarBuilder();
	}
}