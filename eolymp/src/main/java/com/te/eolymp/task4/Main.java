package com.te.eolymp.task4;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String count = in.nextLine();
		List<Line> lines = new ArrayList<>();
		for (int j = 0; j < Integer.valueOf(count); j++) {
			Double[] arr = new Double[Integer.valueOf(count)];
			for (int i = 0; i < 2; i++) {
				arr[i] = Double.valueOf(in.next());
			}
			Line line = new Line((arr[0]).intValue(), arr[1]);
			lines.add(line);
			in.nextLine();
		}

		System.out.println(lines.stream().filter(line -> line.getPrice() < 50).mapToInt(Line::getCount).sum());

		in.close();
	}
}

class Line {

	int count;
	double price;

	public Line(int count, double price) {
		this.count = count;
		this.price = price;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}
}