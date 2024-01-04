package org.example.mvcappboot.exception;

public class InvalidUserException extends RuntimeException {

    public InvalidUserException() {
        super("Invalid user");
    }
}
