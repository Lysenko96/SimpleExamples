package te.lesson2.visitor;

public interface Visitorable {

	void visit(City city);

	void visit(Museum museum);

	void visit(Park park);
}
