package net.gweep.templates.decorator.condiment;

import net.gweep.templates.decorator.Beverage;
import net.gweep.templates.decorator.CondimentDecorator;

public class Soy extends CondimentDecorator{

	private Beverage beverage;
	
	public Soy(Beverage beverage) {
		this.beverage = beverage;
	}
	
	@Override
	public String getDescription() {
		return beverage.getDescription() + ", Soy";
	}

	@Override
	public double cost() {
		return beverage.cost() + 0.15;
	}	
}