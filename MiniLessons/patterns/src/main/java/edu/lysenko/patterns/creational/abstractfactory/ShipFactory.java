package edu.lysenko.patterns.creational.abstractfactory;

public class ShipFactory implements RaceFactory {

	@Override
	public Move doMove() {
		return new ShipMove();
	}

	@Override
	public Fueliable doFuel() {
		return new ShipFuel();
	}

}
