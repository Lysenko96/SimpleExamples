package te.lesson2.state;

public class Configuration extends State {

	public Configuration(Factory factory) {
		super(factory);
	}

	@Override
	public String receive() {
		return "Locked...";
	}

	@Override
	public String configure() {
		return "Configure...";
	}

	@Override
	public String assembly() {
		return "Locked...";
	}
}