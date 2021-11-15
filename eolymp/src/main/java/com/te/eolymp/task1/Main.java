package com.te.eolymp.task1;

import java.util.List;
import java.util.Scanner;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class Main {

	public static void main(String[] args) {
		Main main = new Main();
		Scanner in = new Scanner(System.in);
		List<Integer> values = Stream.of(in.nextLine().split(" ")).map(Integer::valueOf).collect(toList());
		System.out.print(main.computeMedian(values));
		in.close();
	}

	int computeMedian(List<Integer> numbers) {
		int result = -1;
		List<Integer> unique = numbers.stream().distinct().sorted().collect(toList());
		if (unique.size() % 2 != 0) {
			result = unique.get(unique.size() / 2);
		}
		return result;
	}
}