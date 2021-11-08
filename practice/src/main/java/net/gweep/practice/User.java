package net.gweep.practice;

import java.util.Objects;

public class User {

	private String name;
	private int age;
	private double ration;
	private String city;

	public User() {
	}

	public User(String name, int age, double ration, String city) {
		this.name = name;
		this.age = age;
		this.ration = ration;
		this.city = city;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public double getRation() {
		return ration;
	}

	public void setRation(double ration) {
		this.ration = ration;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	@Override
	public int hashCode() {
		return Objects.hash(age, city, name, ration);
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
		return age == other.age && Objects.equals(city, other.city) && Objects.equals(name, other.name)
				&& Double.doubleToLongBits(ration) == Double.doubleToLongBits(other.ration);
	}

	@Override
	public String toString() {
		return "User [name=" + name + ", age=" + age + ", ration=" + ration + ", city=" + city + "]";
	}

	public static User parse(String s) {
		String[] strings = s.split(",");
		return new User(strings[0], Integer.valueOf(strings[1]), Double.valueOf(strings[2]), strings[3]);
	}

}