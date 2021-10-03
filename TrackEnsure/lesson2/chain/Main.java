package te.lesson2.chain;

public class Main {

	private static final String LEVEL = "level";
	
	public static void main(String[] args) {
		Chain chain = make();
		chain.message(LEVEL, 1);
		chain.message(LEVEL, 2);
		chain.message(LEVEL, 3);
		chain.message(LEVEL, 5);
	}

	private static Chain make() {
		Chain chain1 = new First(1);
		Chain chain2 = new Second(3);
		Chain chain3 = new Third(2);
		chain1.setNext(chain2);
		chain2.setNext(chain3);
		return chain1;
	}
}