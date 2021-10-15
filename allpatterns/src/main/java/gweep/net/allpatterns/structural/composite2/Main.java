package gweep.net.allpatterns.structural.composite2;

public class Main {

	public static void main(String[] args) {
		Shape circle = new Circle();
		Shape triangle = new Triangle();
		Shape square = new Square();
		circle.draw();
		System.out.println();
		Shape composite = new Composite();
		Shape composite2 = new Composite();
		((Composite) composite).add(circle);
		((Composite) composite).add(triangle);
		((Composite) composite).add(square);
		((Composite) composite2).add(triangle);
		((Composite) composite2).add(circle);
		((Composite) composite).add(composite2);
		composite.draw();
	}
}