package patterns.abstractfactory;

public class NotebookSoftware implements Configurable {

	@Override
	public void configure() {
		System.out.println("notebook configure");
	}

}
