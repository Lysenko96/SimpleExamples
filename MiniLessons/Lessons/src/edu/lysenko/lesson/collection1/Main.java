package edu.lysenko.lesson.collection1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

import edu.lysenko.abstractclass.IFace;

public class Main {

	public static void main(String[] args) {
		Generator generator = new Generator();
		Map<String, Integer> map = new HashMap<>();
		Map<String, String> table = new Hashtable<>();
		table.put("", "");
		System.out.println(table);
		Set<String> set = new HashSet<>();
		set.add("jun");
		set.add("sen");
		set.add("mid");
		set.add("zip");
		set.add("jun");
		System.out.println(set);
		Set<String> linkedSet = new LinkedHashSet<>();
		linkedSet.add("jun");
		linkedSet.add("sen");
		linkedSet.add("mid");
		linkedSet.add("zip");
		linkedSet.add("jun");
		System.out.println(linkedSet);
		map.put(null, 2);
		System.out.println(map);
		show(generator);

	}

	static void show(Generator generator) {
		ArrayList<String> arrayList = new ArrayList<>(generator.generate(new ArrayList<>()));
		LinkedList<String> linkedList = new LinkedList<>(generator.generate(new LinkedList<>()));
		HashSet<String> hashSet = new HashSet<>(generator.generate(new HashSet<>()));
		LinkedHashSet<String> linkedHashSet = new LinkedHashSet<>(generator.generate(new LinkedHashSet<>()));
		TreeSet<String> treeSet = new TreeSet<>(generator.generate(new TreeSet<>()));
		System.out.println(arrayList);
		System.out.println(generator.next(arrayList));
		System.out.println(generator.next(arrayList));
		System.out.println(generator.next(arrayList));
		System.out.println("---");
		System.out.println(linkedList);
		System.out.println(generator.next(linkedList));
		System.out.println(generator.next(linkedList));
		System.out.println(generator.next(linkedList));
		System.out.println("---");
		System.out.println(hashSet);
		System.out.println(generator.next(hashSet));
		System.out.println(generator.next(hashSet));
		System.out.println(generator.next(hashSet));
		System.out.println("---");
		System.out.println(linkedHashSet);
		System.out.println(generator.next(linkedHashSet));
		System.out.println(generator.next(linkedHashSet));
		System.out.println(generator.next(linkedHashSet));
		System.out.println("---");
		System.out.println(treeSet);
		System.out.println(generator.next(treeSet));
		System.out.println(generator.next(treeSet));
		System.out.println(generator.next(treeSet));
	}

}

abstract class Abstract {

	Abstract() {

	}

}

interface Iface {

}
