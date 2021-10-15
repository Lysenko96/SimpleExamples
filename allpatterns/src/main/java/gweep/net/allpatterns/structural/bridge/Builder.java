package gweep.net.allpatterns.structural.bridge;

public interface Builder {

	default void buildCar(Class<? extends Builder> builderName) {
		System.out.println(builderName.getSimpleName() + " building car...");
	}
}