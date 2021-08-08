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
	private String password;
	private String name;
	private String surname;
	private Role role;

	public User(String email, String password, String name, String surname, Role role) {
		this.email = email;
		this.password = password;
		this.name = name;
		this.surname = surname;
		this.role = role;
	}
}