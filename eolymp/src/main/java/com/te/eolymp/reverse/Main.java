package com.te.eolymp.reverse;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String count = in.nextLine();
		Integer[] arr = new Integer[Integer.valueOf(count)];
		for (int i = 0; i < Integer.valueOf(count); i++) {
			arr[i] = Integer.valueOf(in.next());
		}
		in.nextLine();
		List<Integer> all = new ArrayList<>();
		Collections.addAll(all, Arrays.copyOf(arr, arr.length));

		Map<Integer, Long> map = all.stream()
				.collect(Collectors.groupingBy(n -> n, Collectors.counting()));

		List<Integer> result = new ArrayList<>();
		for (Map.Entry<Integer, Long> pair : map.entrySet()) {
			if (pair.getValue() > 1) {
				result.add(pair.getKey());
			}
		}
		for (Integer r : result) {
			if (all.contains(r)) {
				all.remove(r);
			}
		}
		Collections.reverse(all);
		List<Integer> l = all.stream().distinct().collect(Collectors.toList());
		Collections.reverse(l);
		for (int i = 0; i < l.size() - 1; i++) {
			System.out.print(l.get(i) + " ");
		}
		System.out.println(l.get(l.size() - 1));

		in.close();
	}
}