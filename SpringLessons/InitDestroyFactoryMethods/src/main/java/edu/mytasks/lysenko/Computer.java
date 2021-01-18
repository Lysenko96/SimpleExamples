package edu.mytasks.lysenko;

import java.util.ArrayList;
import java.util.List;

public class Computer {

	// private List<Playable> genreList = new ArrayList<>();

	private Playable game;

	private String modelPC;

	private int pricePC;

	public String getModelPC() {
		return modelPC;
	}

	public void setModelPC(String modelPC) {
		this.modelPC = modelPC;
	}

	public int getPricePC() {
		return pricePC;
	}

	public void setPricePC(int pricePC) {
		this.pricePC = pricePC;
	}

	// IoC
	public Computer(Playable gameGanre) {
		this.game = gameGanre;
	}

	public Computer() {

	}

	public void setGenre(Playable genre) {
		this.game = genre;
	}

	public String runGame() {
		return "Run game! " + game.getGame();
	}

}
