package edu.tasks.springcore;

public class GameShop {

	private Creatable creatable;

	public GameShop() {

	}

	public GameShop(Creatable creatable) {
		this.creatable = creatable;
	}

	public void playGame() {
		System.out.println(creatable.createGame() + " Go to play!");
	}

}
