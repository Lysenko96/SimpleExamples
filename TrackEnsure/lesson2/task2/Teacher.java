package te.lesson2.task2;

import java.io.Serializable;
import java.util.Objects;

public class Teacher implements Workable, Serializable {

	private static final long serialVersionUID = 7940016243073078394L;
	private String name;
	private String surname;

	public Teacher() {

	}

	public Teacher(String name, String surname) {
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
	public String work() {
		return "Give lesson";
	}

	@Override
	public Workable change(Workable workable) {
		return workable;
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
		if (!(obj instanceof Teacher)) {
			return false;
		}
		Teacher other = (Teacher) obj;
		return Objects.equals(name, other.name) && Objects.equals(surname, other.surname);
	}

	@Override
	public String toString() {
		return "Teacher [name=" + name + ", surname=" + surname + "]";
	}
}
