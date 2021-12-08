package com.te.schedule.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Company {

	private int id;
	private String name;
	private String street;
	private int number;
	private int countPerson;
	private Department department;

	public Company(String name, String street, int number, int countPerson, Department department) {
		this.name = name;
		this.street = street;
		this.number = number;
		this.countPerson = countPerson;
		this.department = department;
	}
}