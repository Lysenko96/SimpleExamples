package edu.lysenko.lesson.finaldata;

import java.util.Random;

public class Main {
	static Random rand = new Random(47);
	static final int x;

	static {
		x = rand.nextInt(20);
	}

	Main() {
		final int y = rand.nextInt(20);
		System.out.println("final: " + y);
		System.out.println("static final: " + x);
	}

	public static void main(String[] args) {
		new Main();
		new Main();
		new Main();
		// x = 4;// - not change final
	}

}
