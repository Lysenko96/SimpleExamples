package gweep.net.allpatterns.structural.facade;

public class Main {

	public static void main(String[] args) {
		StageFlow flow = new StageFlow();
		flow.assembling();
		System.out.println();
		flow.testing();
	}
}