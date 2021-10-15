package net.gweep.task6;

import java.util.ArrayDeque;
import java.util.Deque;

public class Main {

	public static void main(String[] args) {
		System.out.println(new Main().check("[]"));
	}

	boolean check(String s) {
		Deque<Character> stack = new ArrayDeque<>();
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			switch (c) {
			case '(':
				stack.push(')');
				break;
			case '[':
				stack.push(']');
				break;
			case '{':
				stack.push('}');
				break;
			case '}':
			case ']':
			case ')':
				if (stack.isEmpty())
					return false;
				char t = stack.pop();
				if (t != c)
					return false;
				break;
			}
		}
		return stack.isEmpty();
	}

}