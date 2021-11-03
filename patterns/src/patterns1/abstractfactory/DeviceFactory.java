package patterns.abstractfactory;

public interface DeviceFactory {

	Assemblable assembly();
	Configurable configure();
}
