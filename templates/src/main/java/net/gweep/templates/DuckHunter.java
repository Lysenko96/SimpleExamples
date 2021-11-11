package net.gweep.templates;

public class DuckHunter implements Flyable, Quackable {

	Flyable f;
	Quackable q;

	DuckHunter() {
		f = new DuckNoFly();
		q = new DuckQuack();
	}

	public void quack() {
		q.quack();
	}

	public void fly() {
		f.fly();
	}

}