package edu.lysenko.container;

import java.util.HashSet;
import java.util.Set;

public class MyCollectionTest {

	public static void main(String[] args) {
		Set<Company> set = new HashSet<>(new MyCollection<>(new Saleforce(), 1));
		System.out.println(set);
		set.addAll(MyCollection.list(new Saleforce(), 2));
		System.out.println(set);
	}
}
