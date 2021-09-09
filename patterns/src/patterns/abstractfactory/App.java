package patterns.abstractfactory;

public class App {

	private Assemblable assemblable;
	private Configurable configurable;

	public App(DeviceFactory factory) {
		assemblable = factory.assembly();
		configurable = factory.configure();
	}

	public void assembly() {
		assemblable.assembly();
	}

	public void configure() {
		configurable.configure();
	}

}
