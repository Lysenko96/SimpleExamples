package edu.lysenko.innerclass;

public class Main {

	public static void main(String[] args) {
		Outer outer = new Outer("world");
		Outer.Inner inner = outer.getInner();
		Outer.Inner.show();
		System.out.println(inner);
	}
}

class Outer {

	private static String str;

	Outer(String str) {
		this.str = str;
	}

	public String getStr() {
		return str;
	}

	public void setStr(String str) {
		this.str = str;
	}

	static class Inner {

		@Override
		public String toString() {
			return new Outer(str).getStr();
		}

		static void show() {
			System.out.println("show");
		}

	}

	Outer getOuter() {
		return Outer.this;
	}

	Inner getInner() {
		return new Inner();
	}
}