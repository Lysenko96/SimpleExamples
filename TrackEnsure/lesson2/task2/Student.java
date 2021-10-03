package te.lesson2.task2;

import java.io.Serializable;
import java.util.Objects;

public class Student implements Workable, Serializable {

	private static final long serialVersionUID = 4703640172659579198L;
	private String name;
	private String surname;

	public Student() {

	}

	public Student(String name, String surname) {
		this.name = name;
		this.surname = surname;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	@Override
	public Workable change(Workable workable) {
		return workable;
	}

	@Override
	public String work() {
		return "Take lesson";
	}

	@Override
	public int hashCode() {
		return Objects.hash(name, surname);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof Student)) {
			return false;
		}
		Student other = (Student) obj;
		return Objects.equals(name, other.name) && Objects.equals(surname, other.surname);
	}

	@Override
	public String toString() {
		return "Student [name=" + name + ", surname=" + surname + "]";
	}
}