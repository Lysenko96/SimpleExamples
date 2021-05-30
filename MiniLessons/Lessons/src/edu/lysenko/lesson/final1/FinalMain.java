package edu.lysenko.lesson.final1;

import java.util.ArrayList;
import java.util.List;

public class FinalMain {

	final static String s = "string";
	final long l;
	final List<String> list;
	final StringBuilder sb;

	FinalMain() {
		l = System.currentTimeMillis();
		System.out.println(l);
		list = new ArrayList<>();
		sb = new StringBuilder("s1");

	}

	public static void main(String[] args) {
		new FinalMain();
	}

}
