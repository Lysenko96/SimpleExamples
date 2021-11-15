package com.te.eolymp.taskl;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;
import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.counting;

public class Main {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		in.nextLine();
		List<Integer> all = Stream.of(in.nextLine().split(" ")).map(Integer::parseInt).collect(toList());

		Map<Integer, Long> map = all.stream().collect(groupingBy(n -> n, LinkedHashMap::new, counting()));

		List<Integer> result = new ArrayList<>();

		for (Map.Entry<Integer, Long> pair : map.entrySet()) {
			if (pair.getValue() > 1) {
				result.add(pair.getKey());
			}
		}

		if (!result.isEmpty()) {
			result.stream().forEach(x -> System.out.print(x + " "));
		} else {
			System.out.println("NO");
		}
		in.close();
	}
}