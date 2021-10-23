package net.gweep.threads5;

public class LiftOff implements Runnable {

	protected int countDown = 5;
	private static int taskCount = 0;
	private final int id = taskCount++;

	LiftOff() {

	}

	LiftOff(int countDown) {
		this.countDown = countDown;
	}

	public String status() {
		String s = "";
		if (countDown > 0) {
			s = "#" + id + "(" + countDown + "), ";
		} else if (countDown == 0) {
			s = "#" + id + "(" + "Boom!" + "), ";
		}
		return s;
	}

	@Override
	public void run() {
		while (countDown-- > 0) {
			System.out.print(status());
			Thread.yield();
		}
	}
}