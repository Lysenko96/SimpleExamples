package gweep.net.allpatterns.creational.abstractfactory.bank;

import gweep.net.allpatterns.creational.abstractfactory.Architector;

public class BankArchitector implements Architector {

	@Override
	public void structuring() {
		System.out.println(this.getClass().getSimpleName() + " structuring bank project...");
	}
}