package gweep.net.allpatterns.structural.facade;

public class Test implements Stage {

	@Override
	public String action() {
		return this.getClass().getSimpleName();
	}
}