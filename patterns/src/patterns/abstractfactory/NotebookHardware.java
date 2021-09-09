package patterns.abstractfactory;

public class NotebookHardware implements Assemblable {

	@Override
	public void assembly() {
		System.out.println("notebook assembly");
	}
	
}
