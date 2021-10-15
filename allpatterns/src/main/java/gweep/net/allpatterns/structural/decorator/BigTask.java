package gweep.net.allpatterns.structural.decorator;

public class BigTask extends TaskDecorator {

	public BigTask(Functionable functionable) {
		super(functionable);
	}

	public int addNewFunc(int value) {

		return value + RESULT;
	}

	@Override
	public int addFunc() {
		return addNewFunc(functionable.addFunc());
	}
}