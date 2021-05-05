package edu.lysenko.iface.factory2;

import java.util.Random;

public class Main {

	private static void gameReady(GameFactory gameFactory) {
		Game g = gameFactory.getGame();
		g.roll();
	}

	public static void main(String[] args) {
		gameReady(new CubeFactory());
		gameReady(new CoinFactory());
	}
}

interface Game {
	void roll();
}

interface GameFactory {
	Game getGame();
}

class Cube implements Game {

	Random rand = new Random();

	@Override
	public void roll() {
		System.out.println(rand.nextInt(7) + 1);
	}
}

class CubeFactory implements GameFactory {

	@Override
	public Game getGame() {
		return new Cube();
	}
}

class Coin implements Game {
	Random rand = new Random();

	@Override
	public void roll() {
		if (rand.nextInt(3) % 2 == 0) {
			System.out.println("heads");
		} else
			System.out.println("tails");
	}
}

class CoinFactory implements GameFactory {

	@Override
	public Game getGame() {
		return new Coin();
	}
}