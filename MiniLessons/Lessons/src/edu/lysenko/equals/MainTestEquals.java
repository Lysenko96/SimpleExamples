package edu.lysenko.equals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainTestEquals {

	public static void main(String[] args) {
		new MainTestEquals().show();
	}

	void show() {
		Sup sup = new Sup();
		Sub sub = new Sub();
		Sub sub2 = new Sub();
		System.out.println(sup.a.equals(sub.a));
		System.out.println(sub.a.equals(sup.a));
		// System.out.println(sub.equals(Sup.Sub()));
		List<Sub> subs = new ArrayList<>();
		subs.add(sub);

		// we can use get() with Arrays.asList(sub, sub2) that contains Sub items
		get(Arrays.asList(sub, sub2));
		// but we can't use get() with List<Sub>()
		get(subs);
	}

	void get(List<? extends Sup> sups) {
		System.out.println(sups);
	}
}