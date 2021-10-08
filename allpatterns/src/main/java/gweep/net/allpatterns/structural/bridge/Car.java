package gweep.net.allpatterns.structural.bridge;

public abstract class Car {

	protected Builder builder;

	protected Car(Builder builder) {
		this.builder = builder;
	}

	void drive(Class<? extends Car> className) {
		System.out.println(className.getSimpleName() + " drive car...");
	}
}
