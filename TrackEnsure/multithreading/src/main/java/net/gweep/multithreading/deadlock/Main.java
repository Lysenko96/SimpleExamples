package net.gweep.multithreading.deadlock;

public class Main {

	public static void main(String[] args) {
		DeadlockRisk deadlock = new DeadlockRisk();
		deadlock.write(Math.PI, Math.E);
		System.out.println(deadlock.read());
	}
}
