package te.lesson.task;

import java.io.Serializable;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
public class Assistant extends Person implements Serializable {

	private static final long serialVersionUID = 8154418747331710481L;
	private Teacher mentor;

	public Assistant(String name, String surname) {
		super(name, surname, new Assistant());
	}

	public Assistant(String name, String surname, Teacher mentor) {
		super(name, surname, new Assistant());
		this.mentor = mentor;
	}

	@Override
	public String work() {
		return "Configure instruments";
	}

	@Override
	public Workable change(Workable workable) {
		return workable;
	}

	@Override
	public String toString() {
		return "Assistant [mentor=" + mentor + ", name=" + name + ", surname=" + surname + ", workable=" + workable
				+ "]";
	}
}