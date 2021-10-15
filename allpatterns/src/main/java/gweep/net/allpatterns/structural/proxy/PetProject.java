package gweep.net.allpatterns.structural.proxy;

public class PetProject implements Project {

	private String url;

	public PetProject(String url) {
		this.url = url;
		load();
	}

	public void load() {
		System.out.println("Loading project from " + url + "...");
	}

	@Override
	public void run() {
		System.out.println("Running project " + url + "...");
	}
}