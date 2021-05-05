package edu.lysenko.composition;

public class Main {

	private static Book book;

	public static void main(String[] args) {
		System.out.println(book);
		if (book == null) {
			book = new Book(220, "Carnegie");
			System.out.println(book);
		}
	}
}
