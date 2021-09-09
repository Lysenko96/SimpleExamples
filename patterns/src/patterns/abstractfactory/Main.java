package patterns.abstractfactory;

public class Main {

	private App app;
	private DeviceFactory factory;
	private String name;

	Main(String name) {
		this.name = name;
	}

	public static void main(String[] args) {
		Main main = new Main("Smartphone");
		if (main.getName().equals("Notebook")) {
			main.setFactory(new NotebookFactory());
			main.setApp(new App(main.factory));
			main.getApp().assembly();
			main.getApp().configure();

		} else {
			main.setFactory(new SmartphoneFactory());
			main.setApp(new App(main.factory));
			main.getApp().assembly();
			main.getApp().configure();
		}

	}

	public App getApp() {
		return app;
	}

	public void setApp(App app) {
		this.app = app;
	}

	public DeviceFactory getFactory() {
		return factory;
	}

	public void setFactory(DeviceFactory factory) {
		this.factory = factory;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
