package net.gweep.task5;

import java.util.ArrayList;
import java.util.List;

public class Main {

	public static void main(String[] args) {

		// left all < x right all > x
		List<Integer> l = new ArrayList<>(List.of(1, 7, 5, 6, 4));
		int x = 5;
		int lI = 0;
		int rI = l.size() - 1;
		while (lI < rI) {
			lI++;
			rI--;
		}
		System.out.println(l);
	}
// remove and add to lass pos
}
