package effectivejava;

public class Main implements Iface {

	public static void main(String[] args) {
		Iface.show();
		Iface.getEntity(1);
		Iface.getEntity("1");
	}
}
