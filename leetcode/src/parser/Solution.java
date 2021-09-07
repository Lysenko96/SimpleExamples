package parser;

public class Solution {

	public String interpret(String command) {
		String s = command.replace("()", "o");
		return s.replace("(al)", "al");
	}

	public static void main(String[] args) {
		Solution solution = new Solution();
		solution.interpret("G()()(al)()(al)");
	}
}
