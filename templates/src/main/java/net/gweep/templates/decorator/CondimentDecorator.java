package net.gweep.templates.decorator;

public abstract class CondimentDecorator extends Beverage {
	
	@Override
	public abstract String getDescription();

	public double sizeCost(Size size) {
		double sizeCost = 0;
		if (size.equals(Size.TALL)) {
			sizeCost = 0.1;
		} else if (size.equals(Size.GRANDE)) {
			sizeCost = 0.15;
		} else if (size.equals(Size.VENTI)) {
			sizeCost = 0.2;
		}
		return sizeCost;
	}
}