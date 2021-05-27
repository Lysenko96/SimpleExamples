package edu.lysenko.innerclass4;

public class Main2 {

	public static void main(String[] args) {
		Inner in = new Main2().new Inner();
		in.setStr("txt");
		System.out.println(in.getStr());
	}

	class Inner {

		private String str;

		void setStr(String str) {
			this.str = str;
		}

		String getStr() {
			return str;
		}
	}
}
