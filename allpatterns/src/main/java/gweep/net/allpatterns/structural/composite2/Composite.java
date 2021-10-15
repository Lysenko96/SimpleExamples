package gweep.net.allpatterns.structural.composite2;

import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Composite implements Shape {

	private List<Shape> components = new ArrayList<>();

	void add(Shape component) {
		components.add(component);
	}

	void remove(Shape component) {
		components.remove(component);
	}

	@Override
	public void draw() {
		for (Shape component : components) {
			component.draw();
		}
	}
}