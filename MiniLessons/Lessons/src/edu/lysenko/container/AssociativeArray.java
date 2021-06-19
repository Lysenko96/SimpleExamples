package edu.lysenko.container;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Random;

public class AssociativeArray<K, V> extends HashMap<K, V> {

	AssociativeArray(Generator<Pair<K, V>> gen, int quantity) {
		for (int i = 0; i < quantity; i++) {
			Pair<K, V> p = gen.next();
			put(p.key, p.value);
		}
	}

	static <K, V> AssociativeArray<K, V> map(Generator<Pair<K, V>> gen, int quantity) {
		return new AssociativeArray<>(gen, quantity);
	}

	public static void main(String[] args) {
		Iterator<Map.Entry<String, Integer>> iterator = AssociativeArray
				.map(new Letters(), new Random().nextInt(10) + 1).entrySet().iterator();
		while (iterator.hasNext()) {
			System.out.println(iterator.next());
		}
	}

}

class Letters implements Generator<Pair<String, Integer>> {
	private int number = 1;
	private char letter = 'A';

	public Pair<String, Integer> next() {
		return new Pair<>("" + letter++, number++);
	}
}
