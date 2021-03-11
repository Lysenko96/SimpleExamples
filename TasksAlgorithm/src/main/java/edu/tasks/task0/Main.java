package edu.tasks.task0;

import java.util.ArrayList;
import java.util.List;

public class Main {

	Main() {
		getMatrix();
	}

	public static void main(String[] args) {
		new Main();
	}

	void getMatrix() {
		List<Integer> l = new ArrayList<>();
		for (int i = 0; i <= 8; i++) {
			l.add(i + 1);
			for (int j = 0; j < 9; j++) {
				if (i < 8) {
					l.add(0);
				}
			}
		}
		int c = 0;
		for (int b = 0; b < l.size(); b++) {
			c++;
			System.out.print(l.get(b));
			if (c % 9 == 0) {
				c = 0;
				System.out.println();
			}

		}
	}
}
//100000000
//020000000
//003000000
//000400000
//000050000
//000006000
//000000700
//000000080
//000000009
