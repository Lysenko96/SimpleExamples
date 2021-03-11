package edu.tasks.task2;

import java.util.ArrayList;
import java.util.List;

// sum Even Fibonacci numbers to 4_000_000

public class Main {

	public static void main(String[] args) {
		long d = 2;
		List<Integer> l = new ArrayList<>();
		l.add(1);
		l.add(2);
		int i = 2;
		while (d < 4_000_000) {
			l.add(l.get(i - 2) + l.get(i - 1));
			if (l.get(i) % 2 == 0) {
				d += l.get(i);
			}
			i++;
		}
		System.out.println(d); // 4613732
	}
}
