package edu.lysenko.lesson.collection;

import java.util.Arrays;
import java.util.List;

public class Main {

	public static void main(String[] args) {
		List<Gerbil> list = Arrays.asList(new Gerbil(3), new Gerbil(26), new Gerbil(14));
		for (Gerbil g : list) {
			g.hop();
		}
	}
}

class Gerbil {

	private int gerbilNumber;

	Gerbil(int i) {
		gerbilNumber = i;
	}

	void hop() {
		System.out.println("gerbil: " + gerbilNumber);
	}
}
