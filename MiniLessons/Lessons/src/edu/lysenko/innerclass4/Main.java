package edu.lysenko.innerclass4;

import edu.lysenko.innerclass2.Iface;
import edu.lysenko.innerclass3.SupClass;

public class Main extends SupClass {

	public static void main(String[] args) {
		System.out.println(new Main().getIface());
	}

	Iface getIface() {
		return new SupClass().new SubClass();
	}

}
