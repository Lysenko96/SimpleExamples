package com.te.eolymp.task12;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashMap;
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
				.collect(Collectors.groupingBy(n -> n, LinkedHashMap::new, Collectors.counting()));

		long max = Collections.max(map.values());

		List<Integer> result = new ArrayList<>();
		for (Map.Entry<Integer, Long> pair : map.entrySet()) {
			if (pair.getValue() == max) {
				result.add(pair.getKey());
			}
		}
		System.out.println(max);
		for (int i = 0; i < result.size() - 1; i++) {
			System.out.print(result.get(i) + " ");
		}
		System.out.println(result.get(result.size() - 1));

		in.close();
	}
}