package edu.tasks.lesson;

class Main2 {

	private String s = "private ";

	String getString(String str) {
		return s += str;
	}

	public static void main(String[] args) {
		Main2 main2 = new Main2();
		System.out.println(main2.getString("Main2: "));
	}

	public String getS() {
		return s;
	}

	public void setS(String s) {
		this.s = s;
	}

}
