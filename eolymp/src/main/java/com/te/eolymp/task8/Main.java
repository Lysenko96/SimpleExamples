package com.te.eolymp.task8;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String count = in.nextLine();
		Integer[] arr = new Integer[Integer.valueOf(count)];
		for (int i = 0; i < Integer.valueOf(count); i++) {
			arr[i] = Integer.valueOf(in.next());
		}
		in.nextLine();
		int max = Arrays.asList(arr).stream().mapToInt(n -> n).max().getAsInt() / 2;
		int min = Arrays.asList(arr).stream().mapToInt(n -> n).min().getAsInt() / 2;
		List<Integer> list = Arrays.asList(arr).stream().map(number -> {
			int result = 0;
			if (number > 0) {
				result = number - max;
			} else if (number < 0) {
				result = number - min;
			}
			return result;
		}).collect(Collectors.toList());
		for (int i = 0; i < list.size() - 1; i++) {
			System.out.print(list.get(i) + " ");
		}
		System.out.println(list.get(list.size() - 1));
		in.close();
	}
}