package gweep.net.allpatterns.creational.prototype;

public class Main {

	public static void main(String[] args) {
		Car tesla = new Car(1, "Tesla", 239);

		System.out.println(tesla);

		CarFactory factory = new CarFactory(tesla);

		Car clone = factory.getCar();

		clone.setModel("TeslaClone");

		System.out.println(clone);
	}
}