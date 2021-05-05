package edu.lysenko.lesson.finaldata;

public class FinalData {

	public static void main(String[] args) {
		Class myClass = new Class();
		System.out.println(myClass);
		myClass.setP(33);
		myClass.setS("arc");
		System.out.println(myClass);
	}
}

final class Class {

	private int p;
	private String s;

	public int getP() {
		return p;
	}

	public void setP(int p) {
		this.p = p;
	}

	public String getS() {
		return s;
	}

	public void setS(String s) {
		this.s = s;
	}

	@Override
	public String toString() {
		return "Class [p=" + p + ", s=" + s + "]";
	}

}