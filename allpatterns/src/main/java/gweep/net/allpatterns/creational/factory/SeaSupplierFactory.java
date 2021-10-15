package gweep.net.allpatterns.creational.factory;

public class SeaSupplierFactory implements SupplierFactory {

	@Override
	public Supplier create() {
		return new SeaSupplier();
	}
}