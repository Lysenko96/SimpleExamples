package access.local;

public class Foreign {

	public static void main(String[] args) {
		PackagedClass pc = new PackagedClass();
	}
}

class PackagedClass {

	public PackagedClass() {
		System.out.println("make class in package");
	}

}
