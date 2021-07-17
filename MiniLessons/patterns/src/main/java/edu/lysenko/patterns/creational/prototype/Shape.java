package edu.lysenko.patterns.creational.prototype;

public abstract class Shape {

	int x;
	int y;
	String color;

	Shape() {

	}

	Shape(int x, int y, String color) {
		this.x = x;
		this.y = y;
		this.color = color;
	}

	Shape(Shape shape) {
		this.x = shape.x;
		this.y = shape.y;
		this.color = shape.color;
	}

	protected abstract Shape clone();

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((color == null) ? 0 : color.hashCode());
		result = prime * result + x;
		result = prime * result + y;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Shape other = (Shape) obj;
		if (color == null) {
			if (other.color != null)
				return false;
		} else if (!color.equals(other.color))
			return false;
		if (x != other.x)
			return false;
		if (y != other.y)
			return false;
		return true;
	}
}
