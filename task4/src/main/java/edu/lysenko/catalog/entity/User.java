package edu.lysenko.catalog.entity;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Objects;

public class User {

	private int id;
	private String email;
	private String password;
	private String name;
	private String surname;
	private LocalDate register;
	private LocalTime lastLogin;
	private Role role;

	public User() {
	}

	public User(String email, String password, String name, String surname, Role role, LocalDate register,
			LocalTime lastLogin) {
		this.email = email;
		this.password = password;
		this.name = name;
		this.surname = surname;
		this.role = role;
		this.register = register;
		this.lastLogin = lastLogin;
	}

	public User(int id, String email, String password, String name, String surname, Role role, LocalDate register,
			LocalTime lastLogin) {
		this.id = id;
		this.email = email;
		this.password = password;
		this.name = name;
		this.surname = surname;
		this.role = role;
		this.register = register;
		this.lastLogin = lastLogin;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public LocalDate getRegister() {
		return register;
	}

	public void setRegister(LocalDate register) {
		this.register = register;
	}

	public LocalTime getLastLogin() {
		return lastLogin;
	}

	public void setLastLogin(LocalTime lastLogin) {
		this.lastLogin = lastLogin;
	}

	@Override
	public int hashCode() {
		return Objects.hash(email, id, lastLogin, name, password, register, role, surname);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof User)) {
			return false;
		}
		User other = (User) obj;
		return Objects.equals(email, other.email) && id == other.id && Objects.equals(lastLogin, other.lastLogin)
				&& Objects.equals(name, other.name) && Objects.equals(password, other.password)
				&& Objects.equals(register, other.register) && role == other.role
				&& Objects.equals(surname, other.surname);
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", email=" + email + ", password=" + password + ", name=" + name + ", surname="
				+ surname + ", register=" + register + ", lastLogin=" + lastLogin + ", role=" + role + "]";
	}
}