package net.gweep.patterns.structural.facade;

public class Main {

	public static void main(String[] args) {
		Device engine = new Device("engine", 100000, Type.ENGINE);
		Device wheel = new Device("wheel", 50000, Type.WHEEL);
		Device corpus = new Device("corpus", 75000, Type.CORPUS);
		CarFactory factory = new CarFactory();
		System.out.println(factory.assembly(engine, wheel, corpus));
	}
}