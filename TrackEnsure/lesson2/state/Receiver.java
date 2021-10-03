package te.lesson2.state;

public class Receiver extends State {

	Receiver(Factory factory) {
		super(factory);
	}

	@Override
	public String receive() {
		return "Receive...";
	}

	@Override
	public String configure() {
		return "Locked...";
	}

	@Override
	public String assembly() {
		return "Locked...";
	}
}