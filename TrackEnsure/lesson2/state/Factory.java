package te.lesson2.state;

public class Factory {

	private State state;

	Factory(String string) {
		if (string.equals("assembly")) {
			state = new Assembling(this);
		} else if (string.equals("configure")) {
			state = new Configuration(this);
		} else {
			state = new Receiver(this);
		}
	}

	public State getState() {
		return state;
	}

	public void setState(State state) {
		this.state = state;
	}

	public State change(State state) {
		return state;
	}
}