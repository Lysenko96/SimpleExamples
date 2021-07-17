package edu.lysenko.patterns.structural.adapter;

public class SquareHole {

	private int side;

	SquareHole(int side) {
		this.side = side;
	}

	int getSide() {
		return side;
	}

	boolean fits(SquarePeg peg) {
		return peg.getArea() <= getArea();
	}

	double getArea() {
		return Math.pow(side, 2);
	}

}
