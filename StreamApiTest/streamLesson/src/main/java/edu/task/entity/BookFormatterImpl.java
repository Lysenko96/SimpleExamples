package edu.task.entity;

import edu.task.behaviour.BookFormatter;

public class BookFormatterImpl implements BookFormatter {

	@Override
	public String accept(Book book) {
		String cost;
		if (book.getPrice() <= 250) {
			cost = "low";
		} else {
			cost = "high";
		}
		return "A " + cost +  ": " +book.getPrice();
	}

}
