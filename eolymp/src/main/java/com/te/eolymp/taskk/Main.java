package com.te.eolymp.taskk;

import java.util.List;
import java.util.Scanner;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class Main {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		in.nextLine();
		List<Integer> numbers = Stream.of(in.nextLine().split(" ")).map(Integer::parseInt).collect(toList());
		List<Integer> list = numbers.stream().distinct().collect(toList());
		list.stream().forEach(x -> System.out.print(x + " "));
		in.close();
	}
}