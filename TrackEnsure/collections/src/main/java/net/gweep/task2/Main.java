package net.gweep.task2;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Deque<Integer> st = new ArrayDeque<>();
		Scanner in = new Scanner(System.in);
		int value = in.nextInt();
		while (value > 0) {
			st.addLast(value % 10);
			value /= 10;
		}
		System.out.println(st);
		in.close();
	}
}