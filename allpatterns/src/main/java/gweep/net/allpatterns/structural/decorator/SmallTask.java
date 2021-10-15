package gweep.net.allpatterns.structural.decorator;

public class SmallTask implements Functionable {

	@Override
	public int addFunc() {
		return RESULT / 2;
	}
}