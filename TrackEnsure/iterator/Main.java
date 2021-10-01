package te.lesson2.iterator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Main {

	public static void main(String[] args) {
		List<Integer> list = new ArrayList<>();
		List<Integer> list1 = new ArrayList<>();
		for (int i = 0; i < 10; i++) {
			list.add(i + 1);
			list1.add(i + 1);
		}
//		Iterator<Integer> it = list.iterator();
//		List<Integer> newL = new ArrayList<>();
//		while (it.hasNext()) {
//			Integer i = it.next();
//			if (i % 2 == 0) {
//				newL.add(i);
//			}
//		}

		list.removeIf(l -> (l % 2 != 0));
		// System.out.println(newL);
		System.out.println(list);
	}
}
