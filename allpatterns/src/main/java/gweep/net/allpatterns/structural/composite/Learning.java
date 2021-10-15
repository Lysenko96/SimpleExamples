package gweep.net.allpatterns.structural.composite;

import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public abstract class Learning {

	protected List<Learning> students = new ArrayList<>();

	abstract void addMentor(Learning mentor);

	abstract void removeMentor(Learning mentor);

	abstract void showMentors();

	public void addStudent(Learning student) {
		students.add(student);
	}

	public void removeStudent(Learning student) {
		students.remove(student);
	}

	public void showStudents() {
		System.out.println(students);
	}
}
