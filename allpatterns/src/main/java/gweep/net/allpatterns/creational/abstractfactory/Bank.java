package gweep.net.allpatterns.creational.abstractfactory;

import gweep.net.allpatterns.creational.abstractfactory.bank.BankTeamFactory;

public class Bank {

	void createBank() {
		ProjectTeamFactory teamFactory = new BankTeamFactory();
		Architector architector = teamFactory.getArchitector();
		Builder builder = teamFactory.getBuilder();
		System.out.println("Creating bank project...");
		architector.structuring();
		builder.build();
	}
}