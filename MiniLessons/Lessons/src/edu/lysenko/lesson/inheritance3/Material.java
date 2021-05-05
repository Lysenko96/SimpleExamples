package edu.lysenko.lesson.inheritance3;

public class Material {

	private String name;

	protected void setMaterial(String newName) {
		this.name = newName;
	}

	public Material(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Material [name=" + name + "]";
	}

}
