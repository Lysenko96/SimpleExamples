package net.gweep.patterns.behavior.command;

public class Main {

	public static void main(String[] args) {
		App app = new App();
		Driver driver = new Driver(new StartCommand(app), new StopCommand(app), new GetLogCommand(app));
		driver.startApp();
		driver.getLogs();
		driver.stopApp();
	}
}