package edu.task.streamapi;

import java.io.File;
import java.io.FileFilter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Callable;

import static java.util.Arrays.asList;

import edu.task.behaviour.BookFormatter;
import edu.task.behaviour.Predicate;
import edu.task.entity.Book;
import edu.task.entity.BookFormatterImpl;
import edu.task.filter.GibsonAndPriceLess350;

public class Main {

	public static final String WILL = "William Gibson";
	public static final String NEAL = "Neal Stephenson";

	Main() throws Exception {

		doing(() -> {
			System.out.println("doing"); // doing
		});
		System.out.println(fetch().call()); // 123

		// Predicate<Book> b = (Book book) -> book.getPrice(); // need return boolean
		// not float
	}

	public static void main(String[] args) throws Exception {

		new Main();

		List<Book> books = asList(new Book(WILL, 399.9f, "Neuromant"), new Book(WILL, 200.9f, "Johnny Mnemonic"),
				new Book(NEAL, 338.7f, "Cryptonomicon"));

		checkFile();

		System.out.println(filterBookAutor(books)); // Book [author=William Gibson, price=399.9, title=Neuromant] Book
													// [author=William Gibson, price=200.9, title=Johnny Mnemonic]

		System.out.println(filterBookPrice(books)); // Book [author=Neal Stephenson, price=338.7, title=Cryptonomicon]

		System.out.println(filterBookPredicate(books, (Book b) -> b.getPrice() >= 350)); // Book [author=William Gibson,
																							// price=399.9, //
																							// title=Neuromant]
		System.out.println(filterBooks(books, NEAL, 330)); // Book [author=Neal Stephenson, price=338.7,
															// title=Cryptonomicon]

		List<Book> autorGibsonAndPriceLess350 = filterBookPredicate(books, new GibsonAndPriceLess350());

		System.out.println(autorGibsonAndPriceLess350); // Book [author=William Gibson, price=200.9, title=Johnny
														// Mnemonic], Book [author=Neal Stephenson, price=338.7,
														// title=Cryptonomicon]

		printBookCost(books, new BookFormatterImpl());

	}

	private Callable<Integer> fetch() {
		return () -> 123;
	}

	private static void doing(Runnable runnbale) {
		runnbale.run();
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
			if (WILL.equals(book.getAuthor())) {
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

	private static List<Book> filterBooks(List<Book> books, String autor, float price) {
		List<Book> result = new ArrayList<>();
		for (Book book : books) {
			if (book.getAuthor().equals(autor) || book.getPrice() <= price) {
				result.add(book);
			}
		}
		return result;
	}

	private static void printBookCost(List<Book> books, BookFormatter formatter) {
		for (Book book : books) {
			String description = formatter.accept(book);
			System.out.println(description);
		}
	}

}
