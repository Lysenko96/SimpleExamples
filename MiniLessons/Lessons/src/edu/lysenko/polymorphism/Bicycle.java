package edu.lysenko.polymorphism;

public class Bicycle extends Cycle {

	Bicycle() {
		System.out.println("Bicycle");
	}

	@Override
	void ride(Engine engine) {
		System.out.println("Bicycle: " + engine);
		System.out.println(wheels());
	}

	@Override
	int wheels() {
		return super.wheels() - 2;
	}

	String balance() {
		return "Bicycle balance";
	}

}
