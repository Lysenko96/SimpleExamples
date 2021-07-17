package edu.lysenko.patterns.structural.adapter;

public class RoundPeg {

	private int radius;

	RoundPeg(int radius) {
		this.radius = radius;
	}

	int getRadius() {
		return radius;
	}

	double getArea() {
		return Math.pow(radius, 2) * Math.PI;
	}

}
