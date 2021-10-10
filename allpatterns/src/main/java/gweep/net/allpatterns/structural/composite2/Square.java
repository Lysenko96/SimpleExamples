package gweep.net.allpatterns.structural.composite2;

public class Square implements Shape {

	@Override
	public void draw() {
		System.out.println(this.getClass().getSimpleName());
	}
}