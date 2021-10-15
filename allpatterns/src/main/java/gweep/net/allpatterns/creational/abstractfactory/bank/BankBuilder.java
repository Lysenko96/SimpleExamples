package gweep.net.allpatterns.creational.abstractfactory.bank;

import gweep.net.allpatterns.creational.abstractfactory.Builder;

public class BankBuilder implements Builder {

	@Override
	public void build() {
		System.out.println(this.getClass().getSimpleName() + " building bank project...");
	}
}