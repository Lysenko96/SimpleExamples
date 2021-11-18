package net.gweep.templates.decorator.beverage;

import net.gweep.templates.decorator.Beverage;

public class Espresso extends Beverage {

	public Espresso() {
		description = "Espresso";
	}
	
	@Override
	public double cost() {
		return 1.99;
	}
}