package gweep.net.allpatterns.creational.factory;

public class FlySupplierFactory implements SupplierFactory {

	@Override
	public Supplier create() {
		return new FlySupplier();
	}
}