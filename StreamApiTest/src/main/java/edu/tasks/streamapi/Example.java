package edu.tasks.streamapi;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import static java.util.Arrays.asList;
import static java.util.Comparator.comparing;

public class Example {

	public static void main(String[] args) {
		List<Game> games = asList(new Game("Wow", 550.4f), new Game("Gta", 1020.4f), new Game("Warcraft", 300.7f));
		Collections.sort(games, new Comparator<Game>() {
			@Override
			public int compare(Game game0, Game game1) {
				return game1.getPrice().compareTo(game0.getPrice());
			}
		});
		System.out.println(games);

		games.sort(comparing(Game::getPrice));

		System.out.println(games);

		games.sort(comparing(Game::getPrice).reversed());

		System.out.println(games);

	}
}

class Game {

	private String name;
	private Float price;

	public Game() {

	}

	public Game(String name, Float price) {
		this.name = name;
		this.price = price;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Float getPrice() {
		return price;
	}

	public void setPrice(Float price) {
		this.price = price;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + Float.floatToIntBits(price);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Game other = (Game) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (Float.floatToIntBits(price) != Float.floatToIntBits(other.price))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Game [name=" + name + ", price=" + price + "]";
	}

}
