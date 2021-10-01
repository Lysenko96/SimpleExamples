package te.lesson2.chain;

public class First extends Chain {

	public First(int value) {
		this.value = value;
	}

	@Override
	void write(String msg) {
		System.out.println("First " + msg);
	}
}