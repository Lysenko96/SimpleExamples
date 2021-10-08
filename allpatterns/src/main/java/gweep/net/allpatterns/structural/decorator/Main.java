package gweep.net.allpatterns.structural.decorator;

public class Main {

	public static void main(String[] args) {
		Functionable bigFunctionable = new BigTask(new Task());
		System.out.println("bigFunctionable: " + bigFunctionable.addFunc());
		Functionable smallFunctionable = new BigTask(new SmallTask());
		System.out.println("smallFunctionable: " + smallFunctionable.addFunc());

	}
}
