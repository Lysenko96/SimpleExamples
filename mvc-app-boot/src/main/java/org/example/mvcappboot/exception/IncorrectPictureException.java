package org.example.mvcappboot.exception;

public class IncorrectPictureException extends RuntimeException{

    public IncorrectPictureException() {
        super("Incorrect contentLength picture");
    }
}
