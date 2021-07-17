package edu.lysenko.patterns.structural.adapter;

public class RoundPegAdapter extends SquarePeg {

	private RoundPeg peg;

	public RoundPegAdapter(RoundPeg peg) {
		this.peg = peg;
	}

	@Override
	double getArea() {
		double roundArea = peg.getArea();
		double diameter = getDiameterSquare(roundArea);
		return getSquareArea(diameter);
	}

	double getDiameterSquare(double roundArea) {
		return 2 * Math.sqrt(roundArea / Math.PI);
	}

	double getSquareArea(double diameterSquare) {
		return Math.pow(diameterSquare, 2);
	}

}
