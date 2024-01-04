package org.example.mvcappboot.controller;

import org.example.mvcappboot.dto.ErrorResponse;
import org.example.mvcappboot.exception.IncorrectPictureException;
import org.example.mvcappboot.exception.InvalidUserException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.io.InvalidClassException;

@ControllerAdvice
public class PictureControllerAdvice {

    @ExceptionHandler(IncorrectPictureException.class)
    public ResponseEntity<?> handleIncorrectPicture(IncorrectPictureException e) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(new ErrorResponse(e.getMessage())); // return json not string
    }


    @ExceptionHandler(InvalidClassException.class)
    public ResponseEntity<?> handleInvalidUser(InvalidUserException e) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(new ErrorResponse(e.getMessage()));
    }
}
