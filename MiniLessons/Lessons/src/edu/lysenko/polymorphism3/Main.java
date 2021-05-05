package edu.lysenko.polymorphism3;

public class Main {

	public static void main(String[] args) {
		new RoundGlyph(3);
		new RectangularGlyph("Rectangular");
	}
}

class Glyph {

	Glyph() {
		print("before new Glyph().draw()");
		draw();
		print("after new Glyph().draw()");
	}

	void draw() {
		print("new Glyph().draw()");
	}

	void print(String s) {
		System.out.println(s);
	}
}

class RoundGlyph extends Glyph {

	private int number = 1;

	RoundGlyph(int n) {
		this.number = n;
		print("new RoundGlyph(int n), number = " + number);
	}

	@Override
	void draw() {
		print("new RoundGlyph(int n).draw(), number = " + number);
	}
}

class RectangularGlyph extends RoundGlyph {

	String str = "string";

	RectangularGlyph(String s) {
		super(2);
		this.str = s;
		print("new RectangularGlyph(int n), str = " + str);
	}

	@Override
	void draw() {
		print("new RectangularGlyph(int n), str = " + str);
	}

}
