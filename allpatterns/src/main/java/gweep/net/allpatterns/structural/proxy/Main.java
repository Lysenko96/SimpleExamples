package gweep.net.allpatterns.structural.proxy;

public class Main {

	public static void main(String[] args) {
		PetProject petProject = new PetProject("https://github.com/lyseno96/petproject");
		System.out.println("...");
		petProject.run();
		ProxyProject petProjectTwo = new ProxyProject("https://github.com/lyseno96/petproject");
		System.out.println("...");
		petProjectTwo.run();
	}
}