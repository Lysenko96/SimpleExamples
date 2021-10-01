package te.lesson2.command;

public class Main {

	public static void main(String[] args) {
		Computer computer = new Computer();
		ShutDownCommand shutDown = new ShutDownCommand(computer);
		RestartCommand restart = new RestartCommand(computer);
		Switch sw = new Switch();
		sw.storeAndExecute(shutDown);
		sw.storeAndExecute(restart);
	}
}
