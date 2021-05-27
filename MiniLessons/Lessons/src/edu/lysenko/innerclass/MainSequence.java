package edu.lysenko.innerclass;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MainSequence {

	public static void main(String[] args) {
		Sequence sequence = new Sequence();
		for (int i = 0; i < 3; i++) {
			sequence.add(sequence.new StringSequence());
		}
		System.out.println(sequence.getItems());
	}
}

class Sequence {

	private List<Object> items = new ArrayList<>();

	void add(Object x) {
		items.add(x);
	}

	class StringSequence {

		String str;
		Random rand = new Random();

		StringSequence() {
			str = generateStr();
			System.out.println(getSequence());
		}

		String generateStr() {
			char[] chars = "abcdefgfhijklmnopqrstuvwwxyz".toCharArray();
			char[] upperChars = "abcdefgfhijklmnopqrstuvwwxyz".toUpperCase().toCharArray();
			StringBuilder sb = new StringBuilder();
			sb.append(upperChars[rand.nextInt(upperChars.length)]);
			for (int i = 0; i < 9; i++) {
				sb.append(chars[rand.nextInt(chars.length)]);
			}
			return sb.toString();
		}

		// method to get link to sup class
		Sequence getSequence() {
			return Sequence.this;
		}

		@Override
		public String toString() {
			return "StringSequence [str=" + str + "]";
		}
	}

	public List<Object> getItems() {
		return items;
	}

	public void setItems(List<Object> items) {
		this.items = items;
	}

}