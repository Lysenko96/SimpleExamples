package gweep.net.allpatterns.structural.facade;

public class Assembly implements Stage {

	@Override
	public String action() {
		return this.getClass().getSimpleName();
	}
}