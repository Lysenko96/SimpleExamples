package net.gweep.patterns.behavior.command;

public class StartCommand implements Command {

	private App app;

	StartCommand(App app) {
		this.app = app;
	}

	@Override
	public void execute() {
		app.start();
	}
}