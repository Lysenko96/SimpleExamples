package edu.tasks.springcore;

import org.springframework.stereotype.Component;

@Component("gameCompany")
public class Company implements Creatable {

	@Override
	public String createGame() {
		return "Game is created!";
	}

}
