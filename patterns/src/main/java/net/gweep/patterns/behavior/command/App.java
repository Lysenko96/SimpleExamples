package net.gweep.patterns.behavior.command;

import java.util.List;
import java.util.Random;

// Receiver
public class App {

	void start() {
		System.out.println("start app");
	}

	List<String> getLogs(List<String> logs) {
		Random random = new Random();
		String[] alphabet = "abcdefghijklmnopqrstuvwxyz".split("");
		for (int i = 0; i < random.nextInt(25); i++) {
			logs.add(new String(alphabet[random.nextInt(25)]));
		}
		return logs;
	}

	void stop() {
		System.out.println("stop app");
	}
}
