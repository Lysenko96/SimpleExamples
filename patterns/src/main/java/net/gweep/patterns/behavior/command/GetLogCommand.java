package net.gweep.patterns.behavior.command;

import java.util.ArrayList;

public class GetLogCommand implements Command {

	private App app;

	GetLogCommand(App app) {
		this.app = app;
	}

	@Override
	public void execute() {
		System.out.println(app.getLogs(new ArrayList<>()));
	}
}
