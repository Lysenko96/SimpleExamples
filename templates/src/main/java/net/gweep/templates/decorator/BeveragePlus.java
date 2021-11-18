package net.gweep.templates.decorator;

public class BeveragePlus {

	protected String description = "uknown beverage";
	private double mochaCost = 0.2;
	private boolean isMocha = false;

	public double cost() {
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
}
