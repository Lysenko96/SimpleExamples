package net.gweep.voting.exception;

public class IncorrectDigitsCountException extends Exception {

	private static final long serialVersionUID = 109247450703625956L;

	public IncorrectDigitsCountException(String errorMessage) {
		super(errorMessage);
	}
}