package gweep.net.allpatterns.creational.factory;

public class FlySupplier implements Supplier {

	@Override
	public void supply() {
		System.out.println(this.getClass().getSimpleName() + " supply product...");
	}
}