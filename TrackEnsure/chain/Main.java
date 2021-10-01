package te.lesson2.chain;

public class Main {

	public static void main(String[] args) {
		Chain chain = make();
		chain.message("level message", 1);
		chain.message("level message", 2);
		chain.message("level message", 3);
		chain.message("level message", 4);
	}

	private static Chain make() {
		Chain chain1 = new First(1);
		Chain chain2 = new Second(2);
		Chain chain3 = new Third(3);
		chain1.setNext(chain2);
		chain2.setNext(chain3);
		return chain1;
	}
}
