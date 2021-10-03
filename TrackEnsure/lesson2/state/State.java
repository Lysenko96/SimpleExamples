package te.lesson2.state;

public abstract class State {

	private Factory factory;

	State(Factory factory) {
		this.factory = factory;
	}

	public abstract String receive();

	public abstract String configure();

	public abstract String assembly();

	public Factory getFactory() {
		return factory;
	}

	public void setFactory(Factory factory) {
		this.factory = factory;
	}
}