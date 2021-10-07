package gweep.net.allpatterns.creational.abstractfactory.bank;

import gweep.net.allpatterns.creational.abstractfactory.Architector;
import gweep.net.allpatterns.creational.abstractfactory.Builder;
import gweep.net.allpatterns.creational.abstractfactory.ProjectTeamFactory;

public class BankTeamFactory implements ProjectTeamFactory {

	@Override
	public Architector getArchitector() {
		return new BankArchitector();
	}

	@Override
	public Builder getBuilder() {
		return new BankBuilder();
	}
}