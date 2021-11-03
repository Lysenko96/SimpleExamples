package net.gweep.patterns.creational.prototype;

public class Main {

	public static void main(String[] args) {
		Car car = new Car("Tesla", 230, 300000);
		System.out.println(car);
		Car copy = (Car) car.copy();
		System.out.println(copy);
		System.out.println(car.hashCode());
		System.out.println(copy.hashCode());

		CarFactory factory = new CarFactory(new Car("Bmw", 220, 250000));
		Car copy1 = factory.makeCopy();
		System.out.println(copy1);
		System.out.println(copy1.hashCode());
	}
}