package edu.tasks.lesson1;

import edu.tasks.lesson3.Main.*;

import edu.tasks.lesson2.Main.*;

public class Main2 {

	public static void main(String[] args) {
//		new Class1().setS("d");
//		new Class2("x");
		//new Main().check();
	}

}

class Class1 {

	String s = "s";

	Class1() {
		System.out.println(s);
	}

	public String getS() {
		return s;
	}

	public void setS(String s) {
		this.s = s;
	}

}

class Class2 {

	String s;

	Class2(String s) {
		this.s = s;
		System.out.println(s);
	}
}