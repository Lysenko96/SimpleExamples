package edu.lysenko.polymorphism3;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Starship {

	public static void main(String[] args) {
		AlertStatus alertStatus = new AlertStatus();
		Random rand = new Random();
		List<AlertStatus> list = Arrays.asList(alertStatus, alertStatus, alertStatus);
		for (AlertStatus status : list) {
			status.change(rand.nextInt(4)).check();
		}
	}
}

class AlertStatus {

	void check() {
	}

	AlertStatus change(int i) {
		if (i == 0) {
			return new Warning();
		} else if (i % 2 == 1) {
			return new Critical();
		} else if (i % 2 == 0) {
			return new Down();
		}
		return null;
	}
}

class Warning extends AlertStatus {

	@Override
	void check() {
		System.out.println("Warning");
	}
}

class Critical extends AlertStatus {

	@Override
	void check() {
		System.out.println("Critical");
	}
}

class Down extends AlertStatus {

	@Override
	void check() {
		System.out.println("Down");
	}
}
