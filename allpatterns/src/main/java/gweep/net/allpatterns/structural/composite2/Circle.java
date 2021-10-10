package gweep.net.allpatterns.structural.composite2;

public class Circle implements Shape{

	@Override
	public void draw() {
		System.out.println(this.getClass().getSimpleName());
	}	
}