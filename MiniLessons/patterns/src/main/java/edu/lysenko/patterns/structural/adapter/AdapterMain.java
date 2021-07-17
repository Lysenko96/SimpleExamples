package edu.lysenko.patterns.structural.adapter;

import java.util.Arrays;
import java.util.List;

public class AdapterMain {

	public static void main(String[] args) {

		SquareHole hole = new SquareHole(5);
		System.out.println("hole area: " + hole.getArea());
		SquarePeg squarePeg = new SquarePeg(6);
		SquarePeg squarePeg2 = new SquarePeg(2);
		List<SquarePeg> squarePegs = Arrays.asList(squarePeg, squarePeg2);

		for (SquarePeg peg : squarePegs) {
			System.out.println("square peg area: " + peg.getArea());
			if (hole.fits(peg)) {
				System.out.println("squarePeg fits squareHole");
			} else {
				System.out.println("squarePeg don't fits squareHole");
			}
		}

		RoundPeg roundPeg = new RoundPeg(6);
		RoundPeg roundPeg2 = new RoundPeg(2);

		List<RoundPeg> pegs = Arrays.asList(roundPeg, roundPeg2);

		for (RoundPeg peg : pegs) {
			System.out.println("round peg area: " + new RoundPegAdapter(peg).getArea());
			if (hole.fits(new RoundPegAdapter(peg))) {
				System.out.println("roundPeg fits squareHole");
			} else {
				System.out.println("roundPeg don't fits squareHole");
			}

		}

	}
}
