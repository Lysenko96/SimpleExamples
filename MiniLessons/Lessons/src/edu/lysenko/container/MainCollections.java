package edu.lysenko.container;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class MainCollections {

	private Random rand = new Random();

	private static final int MAX = 509999999;
	private static final int MIN = 500000000;

	public static void main(String[] args) {
		new MainCollections().generate();
	}

	void generate() {
		List<IntPhone> phones = new ArrayList<>(Collections.nCopies(2, new IntPhone(rand.nextInt(MAX) + MIN)));
		set(phones);
		System.out.println(phones);
		Collections.fill(phones, new IntPhone(rand.nextInt(MAX) + MIN));
		set(phones);
		System.out.println(phones);
	}

	void set(List<IntPhone> phones) {
		while (phones.get(0).equals(phones.get(1))) {
			phones.set(1, new IntPhone(rand.nextInt(MAX) + MIN));
		}
	}
}

class IntPhone {

	private int phone;

	public IntPhone(int phone) {
		this.phone = phone;
	}

	@Override
	public String toString() {
		return "IntPhone [phone=" + phone + "]";
	}

}