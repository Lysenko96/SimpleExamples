package net.pack.jdbcstyle.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Person {

	private long id;
	private String name;
	private String surname;
	private Sex sex;
	private String email;
	private int year;
	private String address;
	private int phone;
	private String postCode;

	public Person(String name, String surname, Sex gender, String email, int age, String address, int phone,
			String postCode) {
		this.name = name;
		this.surname = surname;
		this.sex = gender;
		this.email = email;
		this.year = age;
		this.address = address;
		this.phone = phone;
		this.postCode = postCode;
	}
}