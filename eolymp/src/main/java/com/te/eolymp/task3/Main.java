package com.te.eolymp.task3;

import java.util.Scanner;
import java.util.stream.Stream;

public class Main {

	public static void main(String[] args) {
		Main m = new Main();
		Scanner in = new Scanner(System.in);
		String count = in.nextLine();
		Double[] arr = new Double[Integer.valueOf(count)];
		for (int i = 0; i < Integer.valueOf(count); i++) {
			arr[i] = Double.valueOf(in.next());
		}
		in.nextLine();
		System.out.print(Stream.of(arr).filter(number -> number < 0).count() + " ");
		System.out.printf("%.2f", m.calcSumNegative(arr));
		in.close();
	}

	Double calcSumNegative(Double[] numbers) {
		return Stream.of(numbers).mapToDouble(number -> number).filter(number -> number < 0).sum();
	}
}