package te.lesson2.visitor;

public class FirstVisitor implements Visitorable {

	public static final String VISIT_TO = "Visit ";

	@Override
	public void visit(City city) {
		System.out.println(VISIT_TO + city.getClass().getSimpleName());
	}

	@Override
	public void visit(Museum museum) {
		System.out.println(VISIT_TO + museum.getClass().getSimpleName());
	}

	@Override
	public void visit(Park park) {
		System.out.println(VISIT_TO + park.getClass().getSimpleName());
	}
}