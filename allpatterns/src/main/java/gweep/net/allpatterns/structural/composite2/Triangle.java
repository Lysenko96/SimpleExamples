package gweep.net.allpatterns.structural.composite2;

public class Triangle implements Shape {

	@Override
	public void draw() {
		System.out.println(this.getClass().getSimpleName());
	}
}