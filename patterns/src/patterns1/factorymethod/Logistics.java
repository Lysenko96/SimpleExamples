package patterns.factorymethod;

public abstract class Logistics {

	void planDelivery() {
		Transport t = createTransport();
		t.deliver();
	}

	abstract Transport createTransport();
}
