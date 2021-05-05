package edu.lysenko.polymorphism;

public class Tricycle extends Cycle {

	Tricycle() {
		System.out.println("Tricycle");
	}

	@Override
	void ride(Engine engine) {
		System.out.println("Tricycle: " + engine);
		System.out.println(wheels());
	}

	@Override
	int wheels() {
		return 3;
	}

	String balance() {
		return "Tricycle balance";
	}
}
