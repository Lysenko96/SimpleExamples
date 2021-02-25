package edu.task.entity;

public class Type extends Book {

	private String name;
	private float price;
	private String title;

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

}
