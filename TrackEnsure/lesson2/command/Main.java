package te.lesson2.command;

import java.util.List;

public class Main {

	public static void main(String[] args) {
		Computer computer = new Computer();
		ShutDownCommand shutDown = new ShutDownCommand(computer);
		RestartCommand restart = new RestartCommand(computer);
		Switch sw = new Switch();
		sw.setHistory(List.of(restart, shutDown));
		for (Command c : sw.getHistory()) {
			c.execute();
		}
	}
}
