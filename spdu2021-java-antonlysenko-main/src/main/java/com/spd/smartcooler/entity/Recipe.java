package com.spd.smartcooler.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Recipe {

	private int id;
	private String name;
	private Product product;

	public Recipe(String name, Product product) {
		this.name = name;
		this.product = product;
	}
}