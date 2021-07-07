package edu.lysenko.patterns.creational.abstractfactory;

public class CarFactory implements RaceFactory {

	@Override
	public Move doMove() {
		return new CarMove();
	}

	@Override
	public Fueliable doFuel() {
		return new CarFuel();
	}

}
