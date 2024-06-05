package org.example.web.exception;

public class LowSalaryException extends RuntimeException {

    public LowSalaryException(String message) {
        super(message);
    }
}
