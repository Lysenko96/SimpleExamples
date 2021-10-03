package te.lesson2.state;

public class Assembling extends State {

	Assembling(Factory factory) {
		super(factory);
	}

	@Override
	public String receive() {
		return "Locked...";
	}

	@Override
	public String configure() {
		return "Locked...";
	}

	@Override
	public String assembly() {
		return "Assembly...";
	}
}