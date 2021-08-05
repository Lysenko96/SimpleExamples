package edu.lysenko.task3;

import java.util.ArrayList;
import java.util.List;

public class Logic {

	List<Integer> getWinners(int userMove, int diff) {
		List<Integer> winners = new ArrayList<>();
		for (int i = userMove + 1; i <= userMove + diff; i++) {
			int number = i % 5;
			if (number == 0) {
				winners.add(5);
			} else {
				winners.add(number);
			}
		}
		return winners;
	}

	List<Integer> getLoosers(int userMove, int diff) {
		List<Integer> loosers = new ArrayList<>();
		int temp = userMove;
		for (int i = userMove + 1; i <= userMove + diff; i++) {
			temp--;
			if (temp == 0) {
				loosers.add(5);
			} else if (temp > 0) {
				loosers.add(temp);
			} else if (temp < 0) {
				loosers.add(5 - Math.abs(temp));
			}
		}
		return loosers;
	}
}