package net.gweep.patterns.behavior.command;

// Invoker
public class Driver {

	private Command start;
	private Command stop;
	private Command getLogs;

	Driver(Command start, Command stop, Command getLogs) {
		this.start = start;
		this.stop = stop;
		this.getLogs = getLogs;
	}
	
	void startApp() {
		start.execute();
	}
	
	void stopApp() {
		stop.execute();
	}
	
	void getLogs() {
		getLogs.execute();
	}
}
