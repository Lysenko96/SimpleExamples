package te.lesson2.chain;

public abstract class Chain {

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

	abstract void write(String msg);
}