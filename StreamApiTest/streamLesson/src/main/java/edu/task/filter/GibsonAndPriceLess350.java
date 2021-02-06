package edu.task.filter;

import static edu.task.streamapi.Main.WILL;

import edu.task.behaviour.Predicate;
import edu.task.entity.Book;

public class GibsonAndPriceLess350 implements Predicate<Book> {

	@Override
	public boolean test(Book book) {
		return WILL.equals(book.getTitle()) || book.getPrice() <= 350;
	}

}
