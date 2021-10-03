package te.lesson2.visitor;

import java.util.ArrayList;
import java.util.List;

public class City implements Element {

	List<Element> elements = new ArrayList<>();

	public City() {
		elements.add(new Park());
		elements.add(new Museum());
	}

	@Override
	public void accept(Visitorable visitorable) {
		visitorable.visit(this);
		for (Element elem : elements) {
			elem.accept(visitorable);
		}
	}
}