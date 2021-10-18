package net.gweep.test;

import java.util.Objects;

public class Person {

	static class Instrument {
		String name;

		public Instrument(String name) {
			this.name = name;
		}

	}

	int age;

	public Person() {
	}

	public Person(int age) {
		this.age = age;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "Person [age=" + age + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(age);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof Person)) {
			return false;
		}
		Person other = (Person) obj;
		return age == other.age;
	}

}
