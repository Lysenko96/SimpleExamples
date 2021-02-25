package edu.task.entity;

public class Type extends Book {

	private String name;
	private float price;
	private String title;
	private int number;

	public Type() {

	}

	public Type(String name) {
		this.name = name;
	}

	public Type(String name, float price) {
		this.name = name;
		this.price = price;
	}

	public Type(String name, float price, String title) {
		this.name = name;
		this.price = price;
		this.title = title;
	}

	public Type(String name, float price, String title, int number) {
		this.name = name;
		this.price = price;
		this.title = title;
		this.number = number;
	}

	public String getName() {
		return name;
	}

	public float getPrice() {
		return price;
	}

	public String getTitle() {
		return title;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

}
