package gweep.net.allpatterns.structural.decorator;

public class TaskDecorator implements Functionable {

	protected Functionable functionable;

	public TaskDecorator(Functionable functionable) {
		this.functionable = functionable;
	}

	@Override
	public int addFunc() {
		return functionable.addFunc();
	}
}