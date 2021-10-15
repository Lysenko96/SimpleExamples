package net.gweep.collections;

import java.util.ArrayList;
import java.util.List;

public class Main {

	public static void main(String[] args) {

		List<Integer> l = new ArrayList<>();
		l.add(1);
		l.add(2);
		l.add(3);
		List<Integer> l2 = new ArrayList<>();
		l2.add(1);
		l2.add(4);
		l.retainAll(l2);
		System.out.println(l);
		System.out.println(l2);
//		l.retainAll(l2);
//		System.out.println(l);
//		System.out.println(l2);
	}
}
