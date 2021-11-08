package net.gweep.templates;

public abstract class Duck {

	protected Flyable flyable;
	protected Quackable quackable;

	public void flyGeneral() {
		flyable.fly();
	}

	public void quackGeneral() {
		quackable.quack();
	}

	public void setFlayable(Flyable f) {
		flyable = f;
	}

	public void setQuackable(Quackable q) {
		quackable = q;
	}
}