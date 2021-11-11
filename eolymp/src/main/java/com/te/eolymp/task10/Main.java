package com.te.eolymp.task10;

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
		List<Integer> list = Arrays.asList(arr).stream().distinct().collect(Collectors.toList());
		for (int i = 0; i < list.size() - 1; i++) {
			System.out.print(list.get(i) + " ");
		}
		System.out.println(list.get(list.size() - 1));
		in.close();
	}
}