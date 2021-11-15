package com.te.eolymp.task2;

import java.util.List;
import java.util.Scanner;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class Main {

	public static void main(String[] args) {
		Main m = new Main();
		Scanner in = new Scanner(System.in);
		in.nextLine();
		List<Double> numbers = Stream.of(in.nextLine().split(" ")).map(Double::valueOf).collect(toList());
		if (numbers.stream().mapToDouble(number -> number).filter(number -> number > 0).sum() > 0) {
			System.out.printf("%.2f", m.computeAvgPositive(numbers));
		} else {
			System.out.println("Not Found");
		}
		in.close();
	}

	Double computeAvgPositive(List<Double> numbers) {
		return numbers.stream().mapToDouble(number -> number).filter(number -> number > 0).sum()
				/ numbers.stream().filter(number -> number > 0).count();
	}
}