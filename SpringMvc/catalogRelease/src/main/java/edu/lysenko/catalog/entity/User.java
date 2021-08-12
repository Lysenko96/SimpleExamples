package edu.lysenko.catalog.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {

	private int id;
	private String email;
	private String passwd;
	private String name;
	private String surname;
	private Role role;

	public User(String email, String passwd, String name, String surname, Role role) {
		this.email = email;
		this.passwd = passwd;
		this.name = name;
		this.surname = surname;
		this.role = role;
	}
}