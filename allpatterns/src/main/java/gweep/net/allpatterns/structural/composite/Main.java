package gweep.net.allpatterns.structural.composite;

import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {
		Learning student = new Student("name", new ArrayList<>());
		Learning teamLead = new Mentor("teamLead", null);
		Learning mentor = new Mentor("mentor", new ArrayList<>());

		PersonFactory factoryMentor = new PersonFactory(mentor);
		PersonFactory factoryStudent = new PersonFactory(student);
		Learning learningMentor = factoryMentor.getLearnable();
		Learning learningStudent = factoryStudent.getLearnable();
		learningMentor.addMentor(teamLead);
		learningMentor.addStudent(student);
		learningStudent.addMentor(mentor);
		learningMentor.showMentors();
		learningMentor.showStudents();
		learningStudent.showMentors();
		learningStudent.showStudents();
	}
}