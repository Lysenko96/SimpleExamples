package edu.lysenko.iface4;

import java.util.Random;

public class Main {

	public static void main(String[] args) {
		System.out.print(Randable.RANDOM_INT);
	}
}

interface Randable {
	Random RAND = new Random();
	int RANDOM_INT = RAND.nextInt(10);
}