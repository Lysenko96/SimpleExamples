package edu.lysenko.lesson.inheritance2;

import edu.lysenko.lesson.inheritance3.Material;

public class House extends Material {

	private int count;

	public House(String name, int count) {
		super(name);
		this.count = count;
	}

	public static void main(String[] args) {
		House house = new House("JackHouse", 22);
		System.out.println(house);
		house.changeMaterial("OggiHouse", 33);
		System.out.println(house);
	}

	void changeMaterial(String name, int count) {
		setMaterial(name);
		this.count = count;
	}

	@Override
	public String toString() {
		return "House [count=" + count + ", toString()=" + super.toString() + "]";
	}

}
