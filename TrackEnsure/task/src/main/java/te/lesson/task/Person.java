package te.lesson.task;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public abstract class Person implements Workable {

	protected String name;
	protected String surname;
	protected Workable workable;

	@Override
	public String work() {
		return workable.work();
	}

	@Override
	public Workable change(Workable aWorkable) {
		return workable.change(aWorkable);
	}

}