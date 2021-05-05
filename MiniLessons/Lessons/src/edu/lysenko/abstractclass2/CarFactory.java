package edu.lysenko.abstractclass2;

import java.util.Arrays;
import java.util.List;

public class CarFactory {

	public static void main(String[] args) {
		List<Move> list = Arrays.asList(new Car(), new Tesla(), new Audi());
		move(list);
	}

	static void move(List<Move> list) {
		for (Move m : list) {
			if (m instanceof Audi) {
				m.drive(Engine.AUDI);
				((Audi) m).checkFuel();
			} else if (m instanceof Tesla) {
				m.drive(Engine.TESLA);
				((Tesla) m).checkFuel();
			} else {
				m.drive(Engine.CAR);
				((Car) m).checkFuel();
			}
		}
	}

}

interface Move {

	void drive(Engine e);
}

abstract class Fuel {

	abstract void checkFuel();

}

class Car extends Fuel implements Move {

	FuelType f;

	@Override
	public void drive(Engine e) {
		System.out.println("Car rotate wheels " + e);
	}

	@Override
	void checkFuel() {
		System.out.println("checkFuel " + f.NINETY_TWO);
	}

}

class Audi extends Fuel implements Move {

	@Override
	public void drive(Engine e) {
		System.out.println("Audi rotate wheels " + e);
	}

	@Override
	void checkFuel() {
		System.out.println("checkFuel " + FuelType.NINETY_FIVE);
	}
}

class Tesla extends Fuel implements Move {

	@Override
	public void drive(Engine e) {
		System.out.println("Tesla rotate wheels " + e);
	}

	@Override
	void checkFuel() {
		System.out.println("checkFuel " + FuelType.NINETY_FIVE);
	}
}

enum Engine {

	TESLA, AUDI, CAR
}

enum FuelType {

	NINETY_FIVE, NINETY_TWO
}
