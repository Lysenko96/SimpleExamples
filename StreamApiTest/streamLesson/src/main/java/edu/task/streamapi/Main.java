package edu.task.streamapi;

import java.io.File;
import java.io.FileFilter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import static java.util.Arrays.asList;

public class Main {

	public static void main(String[] args) {

		List<Book> books = asList(new Book("William Gibson", 399.9f, "Neuromant"),
				new Book("William Gibson", 200.9f, "Johnny Mnemonic"),
				new Book("Neal Stephenson", 338.7f, "Cryptonomicon"));

		checkFile();

		for (Book book : filterBookAutor(books)) {
			System.out.println(book); // Book [author=William Gibson, price=399.9, title=Neuromant]
										// Book [author=William Gibson, price=200.9, title=Johnny Mnemonic]
		}
		for (Book book : filterBookPrice(books)) {
			System.out.println(book); // Book [author=Neal Stephenson, price=338.7, title=Cryptonomicon]
		}

		for (Book book : filterBookPredicate(books, (Book b) -> b.getPrice() >= 350)) {
			System.out.println(book); // Book [author=William Gibson, price=399.9, title=Neuromant]
		}
	}

	private static void checkFile() {
		File[] files = new File(
				"/home/gweep/Documents/GitHub/SimpleExamples/StreamApiTest/streamLesson/src/main/java/edu/task/streamapi/")
						.listFiles(new FileFilter() {
							@Override
							public boolean accept(File file) {
								return file.isFile();
							}
						});
		System.out.println(Arrays.toString(files)); // [/home/gweep/Documents/GitHub/SimpleExamples/StreamApiTest/streamLesson/src/main/java/edu/task/streamapi/Main.javaMain.java]

		files = new File(".").listFiles(File::isFile);

		System.out.println(Arrays.toString(files)); // [.\.classpath, .\.project, .\pom.xml]
	}

	private static List<Book> filterBookAutor(List<Book> books) {
		List<Book> result = new ArrayList<>();
		for (Book book : books) {
			if ("William Gibson".equals(book.getAuthor())) {
				result.add(book);
			}
		}
		return result;
	}

	private static List<Book> filterBookPrice(List<Book> books) {
		List<Book> result = new ArrayList<>();
		for (Book book : books) {
			if (book.getPrice() >= 210 && book.getPrice() <= 350) {
				result.add(book);
			}
		}
		return result;
	}

	private static List<Book> filterBookPredicate(List<Book> books, Predicate<Book> p) {
		List<Book> result = new ArrayList<>();

		for (Book book : books) {
			if (p.test(book)) {
				result.add(book);
			}
		}
		return result;
	}

}

interface Predicate<T> {
	boolean test(T t);
}

class Book {

	private String author;
	private float price;
	private String title;

	public Book() {

	}

	public Book(String author, float price, String title) {
		this.author = author;
		this.price = price;
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@Override
	public String toString() {
		return "Book [author=" + author + ", price=" + price + ", title=" + title + "]";
	}

}
