package patterns.abstractfactory;

public class SmartphoneFactory implements DeviceFactory {

	@Override
	public Assemblable assembly() {
		return new SmartphoneHardware();
	}

	@Override
	public Configurable configure() {
		return new SmartphoneSoftware();
	}

}
