package net.lys.jdbc.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Car {

	private int id;
	private String name;
	private int speed;
	private int price;

	public Car(String name, int speed, int price) {
		this.name = name;
		this.speed = speed;
		this.price = price;
	}
}