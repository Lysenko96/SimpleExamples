package com.te.eolymp.task4;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class Main {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		List<Line> lines = new ArrayList<>();
		int count = Integer.parseInt(in.nextLine());
		for (int i = 0; i < count; i++) {
			List<String> line = Stream.of(in.nextLine().split(" ")).collect(toList());
			lines.add(new Line(Integer.parseInt(line.get(0)), Double.parseDouble(line.get(1))));
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