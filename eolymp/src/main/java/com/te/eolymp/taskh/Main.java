package com.te.eolymp.taskh;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import static java.util.stream.Collectors.toList;

public class Main {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String v = in.nextLine();
		List<Integer> numbers = new ArrayList<>();
		for (int i = 1; i < Integer.valueOf(v); i++) {
			numbers.add(i);
		}
		List<Integer> filter = numbers.stream().filter(number -> number % 2 != 0).collect(toList());
		filter.forEach(x -> System.out.print(x + " "));
		in.close();
	}
}