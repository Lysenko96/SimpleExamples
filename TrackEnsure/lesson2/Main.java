package te.lesson2;

public class Main implements Cloneable {

	public static void main(String[] args) {
		MyStack stack = new MyStack();
		stack.push("aa");
		stack.push("bb");
		while (!stack.isEmpty()) {
			System.out.println(stack.pop());
		}
	}
}
