package te.lesson2.chain;

public class Third extends Chain {

	public Third(int value) {
		this.value = value;
	}

	@Override
	public void write(String msg) {
		System.out.println("Third " + msg);
	}
}