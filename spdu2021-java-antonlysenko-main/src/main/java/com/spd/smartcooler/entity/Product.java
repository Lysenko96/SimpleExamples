package com.spd.smartcooler.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Product {

	private int id;
	private String name;
	private int count;
	private Type type;
	private double price;

	public Product(String name, int count, Type type, double price) {
		this.name = name;
		this.count = count;
		this.type = type;
		this.price = price;
	}
}