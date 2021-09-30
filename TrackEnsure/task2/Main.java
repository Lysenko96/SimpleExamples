package te.lesson2.task2;

import java.util.ArrayList;
import java.util.List;

public class Main {

	private static List<Workable> positions = new ArrayList<>();

	public static void main(String[] args) {
		Workable student = new Student("Misha", "Misha");
		positions.add(new Teacher("Vanya", "Vanya"));
		positions.add(new Assistant("Petya", "Petya"));
		positions.add(student);
		for (Workable p : positions) {
			System.out.println(p + System.lineSeparator() + p.work());
		}
		student = student.change(new Assistant("Misha", "Misha"));
		positions.remove(positions.size() - 1);
//		student = new Assistant("Misha", "Misha");
		positions.add(student);
		for (Workable p : positions) {
			System.out.println(p + System.lineSeparator() + p.work());
		}
	}
}
