package patterns.abstractfactory;

public class SmartphoneSoftware implements Configurable {

	@Override
	public void configure() {
		System.out.println("smartphone configure");
	}
}
