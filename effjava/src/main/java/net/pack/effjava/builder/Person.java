package net.pack.effjava.builder;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Person {

	private String name;
	private String surname;
	private int age;
	private String address;
	private int phone;
	private String email;

	public static class Builder {
		private String name;
		private String surname;
		private int phone;

		private int age;
		private String address;
		private String email;

		// required parameters

		public Builder(String name, String surname, int phone) {
			this.name = name;
			this.surname = surname;
			this.phone = phone;
		}

		// not required parameters

		public Builder age(int age) {
			this.age = age;
			return this;
		}

		public Builder address(String address) {
			this.address = address;
			return this;
		}

		public Builder email(String email) {
			this.email = email;
			return this;
		}

		public Person build() {
			return new Person(this);
		}

	}

	private Person(Builder builder) {
		name = builder.name;
		surname = builder.surname;
		phone = builder.phone;
		address = builder.address;
		age = builder.age;
		email = builder.email;
	}

}
