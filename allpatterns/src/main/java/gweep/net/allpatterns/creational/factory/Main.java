package gweep.net.allpatterns.creational.factory;

public class Main {

	public static void main(String[] args) {
		SupplierFactory factory = createFactoryByTypeSupplier("road");
		Supplier supplier = factory.create();
		supplier.supply();
	}

	static SupplierFactory createFactoryByTypeSupplier(String type) {
		switch (type.toLowerCase()) {
		case "road":
			return new RoadSupplierFactory();
		case "sea":
			return new SeaSupplierFactory();
		case "fly":
			return new FlySupplierFactory();
		default:
			throw new RuntimeException(type + " is uknown type.");
		}
	}
}