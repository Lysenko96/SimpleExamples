package net.gweep.patterns.creational.factory;

public class Main {

	public static void main(String[] args) {
		Car tesla = new TeslaFactory().getCar();
		Car bmw = new BmwFactory().getCar();
		System.out.println(tesla);
		System.out.println(bmw);
		tesla.drive();
		bmw.drive();
	}
}