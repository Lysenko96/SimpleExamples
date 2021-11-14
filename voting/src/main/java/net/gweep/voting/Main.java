package net.gweep.voting;

import net.gweep.voting.menu.Menu;
import net.gweep.voting.repo.Repository;

public class Main {

	public static void main(String[] args) {

		Repository repo = new Repository();

		Menu menu = new Menu();

		menu.show(repo);
	}
}