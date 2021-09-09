package patterns.abstractfactory;

public class SmartphoneHardware implements Assemblable {

	@Override
	public void assembly() {
		System.out.println("smartphone assembly");
	}
}
