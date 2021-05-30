package edu.lysenko.lesson.collection1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.SortedMap;
import java.util.SortedSet;

public class Generator {

	private Random rand = new Random();
	private int index;

	String next(Collection<String> collection) {
		List<String> list = new ArrayList<>(collection);
		String s;
		if (list.isEmpty()) {
			return "list is empty";
		} else if (index >= list.size()) {
			index = 0;
			s = list.get(index);
			index++;
			return s;
		} else {
			s = list.get(index);
			index++;
			return s;
		}
	}

	Collection<String> generate(Collection<String> myCollection) {
		Collection<String> collection = Arrays.asList("Arthas", "Thrall", "Azgalor", "Juggernaut", "Disruptor",
				"Pudge");
		int size = rand.nextInt(collection.size());
		Collections.shuffle((List<String>) collection);
		Iterator<String> it = collection.iterator();
		for (int i = 0; i < size; i++) {
			myCollection.add(it.next());
		}
		return myCollection;
	}

}
