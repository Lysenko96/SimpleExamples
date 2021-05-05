package edu.lysenko.iface;

public class Main {

	public static void main(String[] args) {
		Class cl = new Class();
		cl.fastAction(cl);
		cl.fastEat(cl);
		cl.fastSleepFS();
	}

}

class SupClass {

}

class Class extends SupClass implements Life {

	@Override
	public void fastSleepFS() {
		System.out.println("fastSleepFS");
	}

	@Override
	public void fastAction(Action action) {
		System.out.println("fastAction");
	}

	@Override
	public void fastEat(Eat eat) {
		System.out.println("fastEat");
	}

	@Override
	public void check(Life life) {
		System.out.println("check");
	}

}

interface Action {

	default void action(Action action) {
	}

	void fastAction(Action action);
}

interface Eat {

	default void methodEat(Eat eat) {
	}

	void fastEat(Eat eat);

}

interface Sleep {

	default void methodSleep(Sleep sleep) {
	}

	void fastSleepFS();
}

interface Life extends Sleep, Eat, Action {

	void check(Life life);

}
