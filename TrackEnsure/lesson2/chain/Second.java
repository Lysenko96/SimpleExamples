package te.lesson2.chain;

public class Second extends Chain {

	public Second(int value) {
		this.value = value;
	}

	@Override
	public void write(String msg) {
		System.out.println("Second " + msg);
	}
}
