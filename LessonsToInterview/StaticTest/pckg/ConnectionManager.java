package edu.lysenko.pckg;

public class ConnectionManager {

	private static int i;

	static Connection getInstance() {
		if (i < 10) {
			i++;
			return new ConnectionManager().new Connection();
		}
		System.out.println(i);
		return null;
	}

	private class Connection {

		private Connection() {

		}

	}
}
