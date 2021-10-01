package te.lesson.task;

import java.util.ArrayList;
import java.util.List;

public class Main {

	private static List<Person> positions = new ArrayList<>();

	public static void main(String[] args) {
		Workable student = new Student("Misha", "Misha");
		positions.add(new Teacher("Vanya", "Vanya"));
		positions.add(new Assistant("Petya", "Petya"));
		positions.add((Person) student);
		for (Person p : positions) {
			System.out.println(p.getName() + " " + p.getSurname() + " " + p.work());
		}
		student = student.change(new Assistant("Misha", "Misha"));
		positions.remove(positions.size() - 1);
		positions.add((Person) student);
		for (Person p : positions) {
			System.out.println(p.getName() + " " + p.getSurname() + " " + p.work());
		}
	}
}