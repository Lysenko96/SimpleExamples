package com.te.eolymp.task7;

import java.util.List;
import java.util.Scanner;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class Main {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		in.nextLine();
		List<Integer> values = Stream.of(in.nextLine().split(" ")).map(Integer::parseInt).collect(toList());
		int max = values.stream().mapToInt(n -> n).max().getAsInt();
		int min = values.stream().mapToInt(n -> n).min().getAsInt();
		List<Integer> list = values.stream().map(Integer::valueOf).map(number -> number - max + min).collect(toList());
		list.forEach(x -> System.out.print(x + " "));
		in.close();
	}
}