package edu.lysenko.patterns.creational.prototype;

public class Rectangle extends Shape {

	int width;
	int height;

	Rectangle() {

	}

	Rectangle(int width, int height) {
		this.width = width;
		this.height = height;
	}

	Rectangle(Rectangle rectangle) {
		super(rectangle);
		this.width = rectangle.width;
		this.height = rectangle.height;
	}

	@Override
	protected Shape clone() {
		return new Rectangle(this);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + height;
		result = prime * result + width;
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
		Rectangle other = (Rectangle) obj;
		if (height != other.height)
			return false;
		if (width != other.width)
			return false;
		return true;
	}
}
