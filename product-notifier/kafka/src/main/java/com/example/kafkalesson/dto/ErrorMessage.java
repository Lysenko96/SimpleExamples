package com.example.kafkalesson.dto;

public class ErrorMessage extends Exception {

    private String message;

    public ErrorMessage() {
    }

    public ErrorMessage(String message) {
        super(message);
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
