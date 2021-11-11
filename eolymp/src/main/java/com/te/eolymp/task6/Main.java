package com.te.eolymp.task6;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String v = in.nextLine();
		List<Integer> numbers = new ArrayList<>();
		for (int i = 1; i < Integer.valueOf(v); i++) {
			numbers.add(i);
		}
		List<Integer> list = numbers.stream().filter(number -> number % 2 != 0).collect(Collectors.toList());
		for (int i = 0; i < list.size() - 1; i++) {
			System.out.print(list.get(i) + " ");
		}
		System.out.println(list.get(list.size() - 1));
		in.close();
	}
}