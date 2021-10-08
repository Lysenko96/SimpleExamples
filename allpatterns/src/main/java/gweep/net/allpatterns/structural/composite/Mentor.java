package gweep.net.allpatterns.structural.composite;

import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
public class Mentor extends Learning {

	private String name;
	private List<Learning> mentors = new ArrayList<>();

	public void addMentor(Learning mentor) {
		mentors.add(mentor);
	}

	public void removeMentor(Learning mentor) {
		mentors.remove(mentor);
	}

	public void showMentors() {
		System.out.println(mentors);
	}

	@Override
	public String toString() {
		return "Mentor [name=" + name + ", mentors=" + mentors + "]";
	}
}