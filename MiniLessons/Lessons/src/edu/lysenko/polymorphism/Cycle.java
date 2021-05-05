package edu.lysenko.polymorphism;

public class Cycle {

	Cycle() {
		System.out.println("Cycle");
	}

	void ride(Engine engine) {
		System.out.println("Cycle: " + engine);
		System.out.println(wheels());
	}

	int wheels() {
		return 4;
	}

}
