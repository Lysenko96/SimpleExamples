package te.lesson.task;

import java.io.Serializable;
import java.util.List;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
public class Teacher extends Person implements Serializable {

	private static final long serialVersionUID = -4819164201961353492L;
	private List<Student> students;
	private List<Assistant> assistants;

	public Teacher(String name, String surname) {
		super(name, surname, new Teacher());
	}

	public Teacher(String name, String surname, List<Student> students, List<Assistant> assistants) {
		super(name, surname, new Teacher());
		this.students = students;
		this.assistants = assistants;
	}

	@Override
	public String work() {
		return "Give lesson";
	}

	@Override
	public Workable change(Workable workable) {
		return workable;
	}

	@Override
	public String toString() {
		return "Teacher [students=" + students + ", name=" + name + ", surname=" + surname + ", workable=" + workable
				+ "]";
	}
}