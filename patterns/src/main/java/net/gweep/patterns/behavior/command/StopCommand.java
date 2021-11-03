package net.gweep.patterns.behavior.command;

public class StopCommand implements Command {

	private App app;

	StopCommand(App app) {
		this.app = app;
	}

	@Override
	public void execute() {
		app.stop();
	}
}