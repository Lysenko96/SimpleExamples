package net.gweep.templates.decorator.condiment;

import net.gweep.templates.decorator.Beverage;
import net.gweep.templates.decorator.CondimentDecorator;

public class Mocha extends CondimentDecorator {

	private Beverage beverage;
	private Size size;

	public Mocha(Beverage beverage, Size size) {
		beverage.setSize(size);
		this.size = size;
		this.beverage = beverage;
	}

	public String getDescription() {
		return beverage.getDescription() + ", Mocha " + size.name();
	}

	@Override
	public double cost() {
		double sizeCost = sizeCost(size);
		return 0.2 + beverage.cost() + sizeCost;
	}
}