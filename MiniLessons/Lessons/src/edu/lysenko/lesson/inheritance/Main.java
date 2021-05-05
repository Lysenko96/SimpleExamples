package edu.lysenko.lesson.inheritance;

import java.util.Arrays;

public class Main extends Tesla {

	Main() {
		super();
		System.out.println("complete");
	}

	public static void main(String[] args) {
		new Main();
	}
}

class CarFactory {

	Detail[] details = new Detail[10];

	CarFactory() {
		for (int i = 0; i < details.length; i++) {
			details[i] = new Detail();
		}
		System.out.println(Arrays.toString(details));
	}

}

class Tesla extends CarFactory {

	Tesla() {
		super();
		assembly();
	}

	void assembly() {
		System.out.println("assembly details");
	}
}

class Detail {

	private int price;
	private String name;

}