package edu.lysenko.patterns.structural.adapter;

public class SquarePeg {

	private int side;

	public SquarePeg() {
	}

	SquarePeg(int side) {
		this.side = side;
	}

	int getSide() {
		return side;
	}

	double getArea() {
		return Math.pow(side, 2);
	}
}
