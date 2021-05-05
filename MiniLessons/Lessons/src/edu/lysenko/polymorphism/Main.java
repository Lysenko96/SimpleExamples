package edu.lysenko.polymorphism;

import java.util.Arrays;
import java.util.List;

public class Main {

	public static void main(String[] args) {

		List<Cycle> list = Arrays.asList(new Tricycle(), new Bicycle());
		System.out.println(((Bicycle) list.get(1)).balance());
		System.out.println(((Tricycle) list.get(0)).balance());
	}
}