package com.te.eolymp.task8;

import java.util.List;
import java.util.Scanner;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class Main {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		in.nextLine();
		List<Integer> values = Stream.of(in.nextLine().split(" ")).map(Integer::parseInt).collect(toList());
		int max = values.stream().mapToInt(n -> n).max().getAsInt() / 2;
		int min = values.stream().mapToInt(n -> n).min().getAsInt() / 2;
		List<Integer> list = values.stream().map(number -> {
			int result = 0;
			if (number > 0) {
				result = number - max;
			} else if (number < 0) {
				result = number - min;
			}
			return result;
		}).collect(toList());
		list.forEach(x -> System.out.print(x + " "));
		in.close();
	}
}