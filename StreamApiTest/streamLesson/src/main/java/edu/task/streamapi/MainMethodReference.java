package edu.task.streamapi;

import java.util.List;
import java.util.Map;
import java.util.function.BiFunction;
import java.util.function.BiPredicate;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import edu.task.behaviour.TriFunction;
import edu.task.entity.Book;
import edu.task.entity.Type;

import static java.util.Arrays.asList;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

import static java.lang.System.out;

public class MainMethodReference {

	static Map<String, Function<String, Book>> mapBooks = new HashMap<>();
	static List<Book> myListBooks = new ArrayList<>();
	static Book newBook = new Book();
	static Book newBook2 = new Book();
	static Type newType = new Type();
	static {
		Function<String, Book> fBook1 = Book::new;
		newBook = fBook1.apply("author23");
		newBook.setPrice(123.3f);
		out.println(newBook);
		mapBooks.put("genre1", fBook1);
		mapBooks.put("genre2", Type::new); // Type extends Book
		newType.setAuthor("authType");
		newType.setNumber(22);
		Function<String, Book> fBook2 = Book::new;
		newBook2 = fBook2.apply("author21");
		mapBooks.put("genre3", fBook2);

	}

	public static void main(String[] args) {

		List<Double> digits = asList(20.3d, 31.8d, 11.7d, 26.1d);
		digits.sort((n1, n2) -> n2.compareTo(n1));
		out.println(digits); // [31.8, 26.1, 20.3, 11.7]
		digits.sort((Double::compareTo));
		out.println(digits); // [11.7, 20.3, 26.1, 31.8]

		Function<String, Character> stringToCharacter = (String s) -> method(s);
		out.println(stringToCharacter.apply("./run.sh")); // л

		BiPredicate<List<Integer>, Integer> contains = (list, element) -> list.contains(element);
		out.println(contains.test(asList(1, 2, 3), 3)); // 4 - false, 3 - true
		BiPredicate<List<Character>, Character> contains2 = List::contains;
		out.println(contains2.negate().test(asList('z', 'f'), 'z')); // z - false, any symbol but not 'z', 'f' - true
		Supplier<Book> b1 = Book::new;
		b1.get().setAuthor("author"); // not set to book
		b1.get().setPrice(33f); // not set to book
		b1.get().setTitle("title"); // not set to book
		Book a1 = b1.get();
		out.println(a1); // Book [author=null, price=0.0, title=null]
		Supplier<Book> b3 = () -> new Book("auth", 23f, "bookname"); // set to book
		Book a3 = b3.get();
		out.println(a3); // Book [author=auth, price=23.0, title=bookname]
		Function<String, Book> b2 = Book::new;
		Book a2 = b2.apply("new author"); // set in author
		out.println(a2); // Book [author=new author, price=0.0, title=null]
		Function<Type, Book> b4 = Book::new;
		Type t = new Type();
		t.setName("noname"); // set to book
		t.setPrice(100f); // set to book
		t.setTitle("lul"); // set to book
		Book a4 = b4.apply(t); // Book [author=noname, price=100.0, title=lul]
		out.println(a4);
		List<String> authors = Arrays.asList("author", "author1", "author2");
		List<Book> books = map(authors, Book::new);
		out.println(books); // [Book [author=author, price=0.0, title=null], Book [author=author1,
							// price=0.0, title=null], Book [author=author2, price=0.0, title=null]]

		BiFunction<String, Float, Book> bookTwoArgs = Book::new; // method reference constructor
		Book bookObj = bookTwoArgs.apply("author4", 153.4f);
		out.println(bookObj); // Book [author=author4, price=153.4, title=null]
		BiFunction<String, Float, Book> bookTwoArgsL = (author, price) -> new Book(author, price);// method lambda
		Book bookObjL = bookTwoArgsL.apply("author5", 211.7f);
		out.println(bookObjL);// Book [author=author5, price=211.7, title=null]

		Book newBook3 = giveBookForAuthor("genre3", "auth13");
		out.println(newBook3); // give book and change author (if exist key in map)

		myListBooks.add(newBook3);
		myListBooks.add(newBook);
		myListBooks.add(newBook2);
		myListBooks.add(newType); // add Type extends Book
		out.println(myListBooks); // [Book [author=auth13, price=0.0, title=null], Book [author=author23,
									// price=123.3, title=null], Book [author=author21, price=0.0, title=null], Book
									// [author=authType, price=0.0, title=null]]
		out.println(((Type) myListBooks.get(3)).getNumber()); // 22
		TriFunction<String, Float, String, Book> threeArgsBook = Book::new;
		Book threeBook = threeArgsBook.apply("authThree", 22.4f, "threeTitle");
		out.println(threeBook); // Book [author=authThree, price=22.4, title=threeTitle]
	}

	public static char method(String s) {
		char[] chars = s.toCharArray();
		return Stream.of(chars).map((string) -> {
			int number = 0;
			for (char symbol : string) {
				number += symbol + '0';
			}
			return (char) number;
		}).collect(Collectors.toList()).get(0);
	}

	public static List<Book> map(List<String> authors, Function<String, Book> f) {
		List<Book> result = new ArrayList<>();
		for (String author : authors) {
			result.add(f.apply(author));
		}
		return result;
	}

	public static Book giveBookForAuthor(String genre, String author) {
		return mapBooks.get(genre.toLowerCase()).apply(author);
	}
}
