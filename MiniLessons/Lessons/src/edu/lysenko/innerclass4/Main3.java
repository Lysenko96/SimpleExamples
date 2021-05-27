package edu.lysenko.innerclass4;

public class Main3 {

	private int i;

	public static void main(String[] args) {
		System.out.println(new Main3().getInner().getMain3().getI());
	}

	private int method() {
		return 0;
	}

	Inner getInner() {
		Inner in = new Inner();
		in.setInnerI(33);
		return in;
	}

	public int getI() {
		return i;
	}

	public void setI(int i) {
		this.i = i;
	}

	class Inner {

		private Main3 main3 = new Main3();

		void setInnerI(int i) {
			main3.setI(i);
		}

		public Main3 getMain3() {
			return main3;
		}

		public void setMain3(Main3 main3) {
			this.main3 = main3;
		}
	}
}
