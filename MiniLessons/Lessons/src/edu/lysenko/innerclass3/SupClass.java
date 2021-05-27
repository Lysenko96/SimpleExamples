package edu.lysenko.innerclass3;

import edu.lysenko.innerclass2.Iface;

public class SupClass {

	protected class SubClass implements Iface {

		public SubClass() {
			
		}
		
		@Override
		public void method() {
			return;
		}
	}
}
