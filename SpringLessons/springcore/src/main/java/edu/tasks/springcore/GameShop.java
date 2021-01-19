package edu.tasks.springcore;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component("gameShop")
public class GameShop {

	private Creatable creatable;

	@Value("${gameShop.gameName}")
	private String game;

	public GameShop() {

	}

	public String getGame() {
		return game;
	}

	public void setGame(String game) {
		this.game = game;
	}

	public GameShop(Creatable creatable) {
		this.creatable = creatable;
	}

	public String playGame(String game) {
		return creatable.createGame() + " Go to play " + game + "!";
	}

}
