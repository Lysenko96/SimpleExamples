package edu.task.entity;

public class Computer {

	private char ch;
	private char ch1;

	public Computer() {

	}

	public char getCh() {
		return ch;
	}

	public void setCh(char ch) {
		this.ch = ch;
	}

	public char getCh1() {
		return ch1;
	}

	public void setCh1(char ch1) {
		this.ch1 = ch1;
	}

	public static int firstCompute(int number) {
		return number * number - 3 + 5 / 2;
	}

	public static String strTransform(int number) {
		char c = (char) number;
		char c1 = (char) (c + 328 + '0');
		return c + " " + c1 + "";
	}

	public static int[] intTransform(String str) {
		int arr[] = new int[2];
		String[] arrStr = str.split(" ");
		arr[0] = arrStr[0].toCharArray()[0] + '0';
		arr[1] = arrStr[1].toCharArray()[0] + '0';
		return arr;
	}

	public static void main(String[] args) {
		System.out.println(strTransform(22));
		System.out.println(intTransform(strTransform(22))[0]);
		System.out.println(intTransform(strTransform(22))[1]);
	}

}
