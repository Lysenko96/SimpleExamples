package net.gweep.voting.exception;

public class IncorrectVoteCitizenAgeException extends Exception {

	private static final long serialVersionUID = -4762894959167383111L;

	public IncorrectVoteCitizenAgeException(String errorMessage) {
		super(errorMessage);
	}
}
