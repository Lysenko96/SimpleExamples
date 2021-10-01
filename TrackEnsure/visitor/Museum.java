package te.lesson2.visitor;

public class Museum implements Element {

	@Override
	public void accept(Visitorable visitorable) {
		visitorable.visit(this);
	}

}