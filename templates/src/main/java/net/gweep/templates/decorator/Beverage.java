package net.gweep.templates.decorator;

public abstract class Beverage {

	protected String description = "Unknown Beverage";
	private double mochaCost = 0.2;
	private boolean isMocha = false;

	public enum Size {
		TALL, GRANDE, VENTI
	};

	Size size = Size.TALL;

	public String getDescription() {
		return description;
	}

	public Size getSize() {
		return size;
	}

	public void setSize(Size size) {
		this.size = size;
	}

	public double costMocha() {
		double condimentCost = 0.0;
		if (hasMocha()) {
			condimentCost += mochaCost;
		}
		return condimentCost;
	}

	public void setHasMocha(boolean isMocha) {
		this.isMocha = isMocha;
	}

	public boolean hasMocha() {
		return isMocha;
	}

	public abstract double cost();
}
