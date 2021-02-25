package edu.task.entity;

public class Book {

	private String author;
	private float price;
	private String title;

	public Book() {

	}

	public Book(String author) {
		this.author = author;
	}
	
	public Book(String author, float price) {
		this.author = author;
		this.price = price;
	}

	public Book(Type type) {
		this.author = type.getName();
		this.price = type.getPrice();
		this.title = type.getTitle();
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