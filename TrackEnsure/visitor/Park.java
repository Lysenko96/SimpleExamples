package te.lesson2.visitor;

public class Park implements Element {

	@Override
	public void accept(Visitorable visitorable) {
		visitorable.visit(this);
	}
}