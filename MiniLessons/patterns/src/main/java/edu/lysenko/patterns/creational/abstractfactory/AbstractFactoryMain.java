package edu.lysenko.patterns.creational.abstractfactory;

import java.util.Random;

public class AbstractFactoryMain {

	private Move move;
	private Fueliable fule;

	AbstractFactoryMain(RaceFactory race) {
		move = race.doMove();
		fule = race.doFuel();
	}

	public static void main(String[] args) {

		RaceFactory[] factory = new RaceFactory[] { new CarFactory(), new ShipFactory() };

		try {
			for (int i = 0; i < 3; i++) {
				AbstractFactoryMain factoryMain = new AbstractFactoryMain(factory[new Random().nextInt(2)]);
				factoryMain.race();
			}
		} catch (NullPointerException e) {
			System.out.println("npe");
		}
	}

	void race() {
		System.out.println(move.move());
		System.out.println(fule.addFuel());
	}
}
