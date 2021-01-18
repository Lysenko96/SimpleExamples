package edu.mytasks.lysenko;

public class Computer {

	private Playable game;

	// IoC
	public Computer(Playable gameGanre) {
		this.game = gameGanre;
	}

	public String runGame() {
		return "Run game! " + game.getGame();
	}

}
