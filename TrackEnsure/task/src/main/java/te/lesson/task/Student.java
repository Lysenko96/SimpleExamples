package te.lesson.task;

import java.io.Serializable;
import java.util.List;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
public class Student extends Person implements Serializable {

	private static final long serialVersionUID = 5482638451047080425L;
	private List<Teacher> teachers;

	public Student(String name, String surname) {
		super(name, surname, new Student());
	}

	public Student(String name, String surname, List<Teacher> teachers) {
		super(name, surname, new Student());
		this.teachers = teachers;
	}

	@Override
	public String work() {
		return "Take lesson";
	}

	@Override
	public Workable change(Workable workable) {
		System.out.println(this.getClass().getSimpleName() + " " + this.getName() + " " + this.getSurname()
				+ " change to " + workable.getClass().getSimpleName());
		return workable;
	}

	@Override
	public String toString() {
		return "Student [name=" + name + ", surname=" + surname + ", workable=" + workable + "]";
	}
}