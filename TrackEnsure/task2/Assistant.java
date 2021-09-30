package te.lesson2.task2;

import java.util.Objects;

public class Assistant implements Workable {

	private String name;
	private String surname;

	public Assistant() {

	}

	public Assistant(String name, String surname) {
		this.name = name;
		this.surname = surname;
	}

	@Override
	public Workable change(Workable workable) {
		return workable;
	}

	@Override
	public String work() {
		return "Assistant work";
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
	public int hashCode() {
		return Objects.hash(name, surname);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof Assistant)) {
			return false;
		}
		Assistant other = (Assistant) obj;
		return Objects.equals(name, other.name) && Objects.equals(surname, other.surname);
	}

	@Override
	public String toString() {
		return "Assistant [name=" + name + ", surname=" + surname + "]";
	}
}