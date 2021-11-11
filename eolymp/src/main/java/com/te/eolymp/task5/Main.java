package com.te.eolymp.task5;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		List<Integer> numbers = new ArrayList<>();
		while (true) {
			String v = in.nextLine();
			numbers.add(Integer.valueOf(v));
			if (v.equals("0")) {
				break;
			}
		}
		System.out.print(numbers.stream().filter(number -> number > 0).mapToInt(number -> number).sum());
		in.close();
	}
}