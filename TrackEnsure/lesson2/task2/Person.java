package te.lesson2.task2;

public abstract class Person implements Workable {

	private String name;
	private String surname;
	private Workable workable;

	public Person() {

	}

	public Person(String name, String surname, Workable workable) {
		this.name = name;
		this.surname = surname;
		this.workable = workable;
	}

	@Override
	public String work() {
		return workable.work();
	}

	@Override
	public Workable change(Workable workable) {
		return workable.change(workable);
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

	public Workable getWorkable() {
		return workable;
	}

	public void setWorkable(Workable workable) {
		this.workable = workable;
	}
	
	
}
