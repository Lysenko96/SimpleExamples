package te.lesson2.state;

public class UI {

	private Factory factory;

	public UI(Factory factory) {
		this.factory = factory;
	}

	public void init() {
		System.out.println(factory.getState().receive());
		System.out.println(factory.getState().assembly());
		System.out.println(factory.getState().configure());
	}
}