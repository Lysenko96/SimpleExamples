package edu.lysenko.lesson.collection1;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.TreeSet;

public class Main {

	public static void main(String[] args) {
		Generator generator = new Generator();
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
