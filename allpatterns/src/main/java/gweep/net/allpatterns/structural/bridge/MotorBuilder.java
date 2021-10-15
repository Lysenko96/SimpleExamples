package gweep.net.allpatterns.structural.bridge;

public class MotorBuilder implements Builder {

	@Override
	public void buildCar(Class<? extends Builder> builderName) {
		Builder.super.buildCar(builderName);
		System.out.println(this.getClass().getSimpleName().replace("Builder", "") + " showing...");
	}
}