package net.gweep.templates.decorator.beverage;

import net.gweep.templates.decorator.BeveragePlus;

public class DarkRoastPlus extends BeveragePlus {

	public DarkRoastPlus() {
		description = "DarkRoastPlus";
	}

	@Override
	public double cost() {
		return 1.99 + super.cost();
	}

}
