package patterns.abstractfactory;

public class NotebookFactory implements DeviceFactory {

	@Override
	public Assemblable assembly() {
		return new NotebookHardware();
	}

	@Override
	public Configurable configure() {
		return new NotebookSoftware();
	}

}
