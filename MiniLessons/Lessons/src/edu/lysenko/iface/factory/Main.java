package edu.lysenko.iface.factory;

public class Main {

	public static void rideCycle(CycleFactory factory) {
		Cycle s = factory.getCycle();
		s.ride();
	}

	public static void main(String[] args) {
		rideCycle(new BicycleFactory());
		rideCycle(new UnicycleFactory());
		rideCycle(new TricycleFactory());
	}
}

interface Cycle {
	void ride();
}

interface CycleFactory {
	Cycle getCycle();
}

class Bicycle implements Cycle {

	private int moves = 0;
	private static final int MOVES = 2;

	@Override
	public void ride() {
		while (moves < MOVES) {
			System.out.println("Bicycle move " + (moves + 1));
			moves++;
		}
	}
}

class BicycleFactory implements CycleFactory {

	@Override
	public Cycle getCycle() {
		return new Bicycle();
	}

}

class Unicycle implements Cycle {

	private int moves = 0;
	private static final int MOVES = 1;

	@Override
	public void ride() {
		while (moves < MOVES) {
			System.out.println("Unicycle move " + (moves + 1));
			moves++;
		}
	}
}

class UnicycleFactory implements CycleFactory {

	@Override
	public Cycle getCycle() {
		return new Unicycle();
	}
}

class Tricycle implements Cycle {

	private int moves = 0;
	private static final int MOVES = 3;

	@Override
	public void ride() {
		while (moves < MOVES) {
			System.out.println("Tricycle move " + (moves + 1));
			moves++;
		}
	}
}

class TricycleFactory implements CycleFactory {

	@Override
	public Cycle getCycle() {
		return new Tricycle();
	}
}
