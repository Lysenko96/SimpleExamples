package org.example.mvcapp.controller;

import org.example.mvcapp.exception.MessageNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class MessageControllerAdvice {

    @ExceptionHandler(MessageNotFoundException.class)
    public ResponseEntity<String> handleNotFound(MessageNotFoundException e){
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(e.getMessage());
    }

}
