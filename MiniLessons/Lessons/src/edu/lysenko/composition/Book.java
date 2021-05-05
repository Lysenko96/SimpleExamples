package edu.lysenko.composition;

public class Book {

	private int price;
	private String author;

	public Book() {

	}

	public Book(int price, String author) {
		this.price = price;
		this.author = author;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	@Override
	public String toString() {
		return "Book [price=" + price + ", author=" + author + "]";
	}

}
