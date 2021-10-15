package net.gweep.task3.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Car {

	private int id;
	private Model model;
	private int year;
	private int price;
	private String number;
}