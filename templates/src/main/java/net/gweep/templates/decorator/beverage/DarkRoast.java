package net.gweep.templates.decorator.beverage;

import net.gweep.templates.decorator.Beverage;

public class DarkRoast extends Beverage {

	public DarkRoast() {
		description = "DarkRoast";
	}

	@Override
	public double cost() {
		return 0.99 + costMocha();
	}

}
