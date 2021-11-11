package com.te.eolymp.task1;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Main main = new Main();
		Scanner in = new Scanner(System.in);
		String v = in.nextLine();
		String[] arrS = v.split(" ");
		Integer[] arr = new Integer[arrS.length];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = Integer.valueOf(arrS[i]);
		}
		System.out.print(main.calcMedian(arr));
		in.close();
	}

	int calcMedian(Integer[] arr) {
		List<Integer> numbers = Arrays.asList(arr);
		int result = -1;
		for (int i = 0; i < numbers.size(); i++) {
			int countMore = 0;
			int countLess = 0;
			for (int j = 0; j < numbers.size(); j++) {
				if (i != j && numbers.get(i) > numbers.get(j)) {
					countMore++;
				} else if (i != j && numbers.get(i) < numbers.get(j)) {
					countLess++;
				}
			}
			if (countMore == countLess) {
				result = numbers.get(i);
			}
		}
		return result;
	}
}