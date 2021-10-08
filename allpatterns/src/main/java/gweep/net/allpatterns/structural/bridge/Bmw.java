package gweep.net.allpatterns.structural.bridge;

public class Bmw extends Car {

	Bmw(Builder builder) {
		super(builder);
	}

	@Override
	void drive(Class<? extends Car> className) {
		builder.buildCar(builder.getClass());
		super.drive(className);
	}
}