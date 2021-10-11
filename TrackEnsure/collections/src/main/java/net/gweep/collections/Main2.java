package net.gweep.collections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class Main2 {

	public static void main(String[] args) {
		Main2 m2 = new Main2();
		// m2.run();
		// m2.runList();
		m2.runQueue();
		// set contains map
		//not change value int set
		// delete value from set and add new value in set
		// empty collections that not use null object
		// unmodifiable that send data in method and it data not changing
	}

	private void run() {
		List<Integer> list = new ArrayList<>(List.of(1, 2, 3, 4, 5, 6, 3, 2, 5, 9));
		for (Iterator<Integer> it = list.iterator(); it.hasNext();) {
			Integer x = it.next();
			System.out.println(x + " ");
		}
		System.out.println();
		//
		Integer[] arr = {};
		arr = list.toArray(arr);
		int sum = 0;
		for (Integer i : arr) {
			if (i != null) {
				sum += i;
				System.out.println(i + " ");
			}
		}

		HashSet<Integer> set = createSet();

		// разделить хэш на количество корзин поиск в хэш сет

		for (int i = 10; i < 20; i++) {
			set.add(i);
		}
		set.add(1024);
		set.add(1040);

		System.out.println(set);

		set.add(20);
		set.add(21);
		set.add(22);
		set.add(23);

		System.out.println(set);

		System.out.println(sum);
		System.out.println(Arrays.toString(arr));
	}

	private void runList() {
		List<Integer> list = new ArrayList<>(List.of(1, 2, 3, 4, 5, 6, 3, 2, 5, 9));
		List<Integer> subList = list.subList(5, 9);
		System.out.println(list);
		System.out.println(subList);
		subList.set(3, 25);
		System.out.println(subList);
		System.out.println(list);
	}

	private void runQueue() {
		List<Integer> list = new ArrayList<>(List.of(1, 2, 3, 4, 5, 6, 3, 2, 5, 9));

		Queue<Integer> queue = new PriorityQueue<>(list);

		for (Integer n : queue) {
			System.out.print(n + " ");
		}
		System.out.println();
		while (!queue.isEmpty()) {
			System.out.print(queue.poll() + " ");
		}
		System.out.println();
	}

	public HashSet<Integer> createSet() {

		return new HashSet<>();
	}
}
