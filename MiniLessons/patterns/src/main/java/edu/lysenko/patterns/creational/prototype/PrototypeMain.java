package edu.lysenko.patterns.creational.prototype;

import java.util.ArrayList;
import java.util.List;

public class PrototypeMain {

	public static void main(String[] args) {
		List<Shape> shapes = new ArrayList<>();
		List<Shape> shapesCopy = new ArrayList<>();

		Circle myCircle = new Circle(12);
		myCircle.x = 15;
		myCircle.y = 28;
		myCircle.color = "green";
		shapes.add(myCircle);

		Circle prototypeCircle = (Circle) myCircle.clone();
		shapes.add(prototypeCircle);

		Rectangle myRectangle = new Rectangle(14, 19);
		myRectangle.color = "black";
		shapes.add(myRectangle);

		shapes.add(myRectangle);

		myCompare(shapes, shapesCopy);
	}

	static void myCompare(List<Shape> shapes, List<Shape> shapesCopy) {
		int count = 0;
		for (Shape shape : shapes) {
			if (count % 2 == 0) {
				shapesCopy.add(shape.clone());
			} else if (count == 3) {
				shapesCopy.add(new Rectangle());
			} else {
				shapesCopy.add(shape);
			}
			count++;
		}

		for (int i = 0; i < shapes.size(); i++) {
			if (shapes.get(i) != shapesCopy.get(i)) {
				System.out.println(i + ": different obj");
				if (shapes.get(i).equals(shapesCopy.get(i))) {
					System.out.println(i + ": identical obj");
				} else {
					System.out.println(i + ": not identical obj");
				}
			} else {
				System.out.println(i + ": obj same");
			}
		}
	}
}
