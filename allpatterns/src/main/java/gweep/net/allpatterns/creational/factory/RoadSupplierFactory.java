package gweep.net.allpatterns.creational.factory;

public class RoadSupplierFactory implements SupplierFactory {

	@Override
	public Supplier create() {
		return new RoadSupplier();
	}
}