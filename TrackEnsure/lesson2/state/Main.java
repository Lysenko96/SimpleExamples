package te.lesson2.state;

public class Main {

	public static void main(String[] args) {
		Factory factory = new Factory("configure");
		UI ui = new UI(factory);
		ui.init();
		State state = factory.change(new Factory("assembly").getState());
		ui = new UI(state.getFactory());
		ui.init();
	}
}
