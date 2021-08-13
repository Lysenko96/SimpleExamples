package edu.lysenko.catalog.entity;

import java.util.List;

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
	private List<Task> tasks;
	private Role role;

	public User(String email, String passwd, String name, String surname, List<Task> tasks, Role role) {
		this.email = email;
		this.passwd = passwd;
		this.name = name;
		this.tasks = tasks;
		this.surname = surname;
		this.role = role;
	}
}