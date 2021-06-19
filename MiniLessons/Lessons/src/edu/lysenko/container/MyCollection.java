package edu.lysenko.container;

import java.util.ArrayList;

public class MyCollection<T> extends ArrayList<T> {

	MyCollection(Generator<T> gen, int quantity) {
		for (int i = 0; i < quantity; i++) {
			add(gen.next());
		}
	}

	static <T> MyCollection<T> list(Generator<T> gen, int quantity) {
		return new MyCollection<>(gen, quantity);
	}

}
