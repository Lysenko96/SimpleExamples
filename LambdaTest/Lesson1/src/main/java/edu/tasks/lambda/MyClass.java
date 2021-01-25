package edu.tasks.lambda;

public class MyClass {

	//Overload
	
	public Object getStatic(Object obj) {
		return "MyClass(obj): " + obj;
	}

	public String getStatic() {
		return "MyClass(): " + new Object();
	}
}
