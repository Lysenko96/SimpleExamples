package edu.lysenko.lesson.delegation;

public class Detergent {

	private Cleanser cleanser = new Cleanser();

	public void append(String a) {
		String s = cleanser.getS();
		s += a;
	}

	public void dilute() {
		cleanser.append(" dilute()");
	}

	public void apply() {
		cleanser.append(" apply()");
	}

	public void scrub() {
		cleanser.append(" Detergent.scrub()");
		cleanser.append(" scrub()");
	}

	public static void main(String[] args) {
		Detergent detergent = new Detergent();
		detergent.dilute();
		detergent.apply();
		detergent.scrub();
		System.out.println(detergent);
		System.out.println("check base class");
		Cleanser.main(args);
	}

	@Override
	public String toString() {
		return cleanser.toString();
	}

}

class Cleanser {

	private String s = "Cleanser";

	public void append(String a) {
		s += a;
	}

	public void dilute() {
		append(" dilute()");
	}

	public void apply() {
		append(" apply()");
	}

	public void scrub() {
		append(" scrub()");
	}

	@Override
	public String toString() {
		return s;
	}

	public static void main(String[] args) {
		Cleanser x = new Cleanser();
		x.dilute();
		x.apply();
		x.scrub();
		System.out.println(x);
	}

	public String getS() {
		return s;
	}

	public void setS(String s) {
		this.s = s;
	}

}
