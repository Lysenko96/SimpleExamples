package gweep.net.allpatterns.structural.proxy;

public class ProxyProject implements Project {

	private String url;
	private PetProject petProject;

	public ProxyProject(String url) {
		this.url = url;
	}

	@Override
	public void run() {
		if (petProject == null) {
			petProject = new PetProject(url);
		}
		petProject.run();
	}
}
