package net.gweep.voting;

import net.gweep.voting.entity.Candidate;
import net.gweep.voting.entity.Citizen;

public class Main {

	public static void main(String[] args) {
		Citizen citizen = new Candidate();
		citizen.setIdCard(1234564321l);
		citizen.checkIdCard(citizen.getIdCard());
		System.out.println(citizen.getIdCard());
	}
}