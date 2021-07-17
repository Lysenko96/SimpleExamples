package edu.lysenko.patterns.creational.prototype;

public class Circle extends Shape {

	int radius;

	Circle() {
	}

	Circle(int radius) {
		this.radius = radius;
	}

	Circle(Circle circle) {
		super(circle);
		this.radius = circle.radius;
	}

	@Override
	protected Shape clone() {
		return new Circle(this);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + radius;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Circle other = (Circle) obj;
		if (radius != other.radius)
			return false;
		return true;
	}
}
