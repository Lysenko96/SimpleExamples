package edu.lysenko.abstractclass;

public class Main2 {
	
	public static void main(String[] args) {

		AbstractClass cl = new Sub2Class();
		
		// abstract method don't need (cast)
		((Sub2Class) cl).show(); 
		
		cl.show();

	}
}

abstract class AbstractClass {

	abstract void show();

}

class Sub2Class extends AbstractClass {

	//static cat not abstract
	static void method(AbstractClass a) {
		System.out.println("Sub2Class method");
	}

	void show() {
		System.out.println("Sub2Class show");
	}
}