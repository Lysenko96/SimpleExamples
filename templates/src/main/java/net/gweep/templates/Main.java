package net.gweep.templates;

public class Main {

	public static void main(String[] args) {

		Duck d = new DuckOne(new DuckNoFly(), new DuckQuack());
		d.flyGeneral();
		d.quackGeneral();
		d.setFlayable(new DuckFly());
		d.setQuackable(new DuckNoQuack());
		System.out.println();
		d.flyGeneral();
		d.quackGeneral();
	}
}