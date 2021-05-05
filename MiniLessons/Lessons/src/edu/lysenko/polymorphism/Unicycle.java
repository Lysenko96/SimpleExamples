package edu.lysenko.polymorphism;

public class Unicycle extends Cycle {

	Unicycle() {
		System.out.println("Unicycle");
	}

	@Override
	void ride(Engine engine) {
		System.out.println("Unicycle: " + engine);
		System.out.println(wheels());
	}

	@Override
	int wheels() {
		return super.wheels() - 3;
	}

}
