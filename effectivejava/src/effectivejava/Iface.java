package effectivejava;

public interface Iface {

	static void show() {
		System.out.println("show()");
	}

	static EntityOne getEntity(int n) {
		return new EntityOne();
	}

	static EntityTwo getEntity(String s) {
		return new EntityTwo();
	}
}
