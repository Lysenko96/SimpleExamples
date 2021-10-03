package te.lesson2.memento;

import java.io.Serializable;
import java.util.Objects;

public class Snapshot implements Serializable {

	private static final long serialVersionUID = -7447906678144686944L;
	private String name;
	private String surname;

	public Snapshot() {
	}

	public Snapshot(String name, String surname) {
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
	public int hashCode() {
		return Objects.hash(name, surname);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof Snapshot)) {
			return false;
		}
		Snapshot other = (Snapshot) obj;
		return Objects.equals(name, other.name) && Objects.equals(surname, other.surname);
	}

	@Override
	public String toString() {
		return "Snapshot [name=" + name + ", surname=" + surname + "]";
	}
}