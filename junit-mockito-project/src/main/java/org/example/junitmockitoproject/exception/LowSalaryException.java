package org.example.junitmockitoproject.exception;

public class LowSalaryException extends RuntimeException {

    public LowSalaryException(String message) {
        super(message);
    }
}
