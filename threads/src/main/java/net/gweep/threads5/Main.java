package net.gweep.threads5;

public class Main {

	public static void main(String[] args) {
		for (int i = 0; i < 5; i++) {
			Thread d = new Thread(new LiftOff());
			d.setDaemon(true);
			d.start();
			System.out.println("Waiting...");
		}
	}
}