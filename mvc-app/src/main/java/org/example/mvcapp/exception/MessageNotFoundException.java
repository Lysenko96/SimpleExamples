package org.example.mvcapp.exception;

public class MessageNotFoundException extends Exception{

    public MessageNotFoundException() {
    }

    public MessageNotFoundException(String message) {
        super(message);
    }
}
