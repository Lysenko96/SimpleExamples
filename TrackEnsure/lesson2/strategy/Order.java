package te.lesson2.strategy;

public class Order {

	private int total = 0;
	private boolean isClosed = false;

	public void process(PayStrategy strategy) {
		strategy.getInfo();
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total += total;
	}

	public boolean isClosed() {
		return isClosed;
	}

	public void setClosed(boolean isClosed) {
		this.isClosed = isClosed;
	}
}