package te.lesson2.chain;

public class Chain implements IChain {

	protected int value;
	protected Chain next;

	public int getValue() {
		return value;
	}

	public Chain getNext() {
		return next;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public void setNext(Chain next) {
		this.next = next;
	}

	public void message(String msg, int priority) {
		if (priority <= value) {
			write(msg);
		} else {
			if (next != null) {
				next.message(msg, priority);
			}
		}
	}

	@Override
	public void write(String msg) {
		new Chain().write(msg);
	}
}