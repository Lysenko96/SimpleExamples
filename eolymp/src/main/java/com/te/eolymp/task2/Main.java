package com.te.eolymp.task2;

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
		if (Stream.of(arr).mapToDouble(number -> number).filter(number -> number > 0).sum() > 0) {
			System.out.printf("%.2f", m.calcAveragePositive(arr));
		} else {
			System.out.println("Not Found");
		}
		in.close();
	}

	Double calcAveragePositive(Double[] numbers) {
		return Stream.of(numbers).mapToDouble(number -> number).filter(number -> number > 0).sum()
				/ Stream.of(numbers).filter(number -> number > 0).count();
	}
}