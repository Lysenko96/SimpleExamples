package net.gweep.multithreading.synch;

public class Main {

	public static void main(String[] args) throws Exception {
		IncrementerThread.runExperiment(new Counter());
		IncrementerThread.runExperiment(new Counter());
	}
}
