package com.spd.smartcooler.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Cooler {

	private int id;
	private String model;
	private Product product;

	public Cooler(String model, Product product) {
		this.model = model;
		this.product = product;
	}
}