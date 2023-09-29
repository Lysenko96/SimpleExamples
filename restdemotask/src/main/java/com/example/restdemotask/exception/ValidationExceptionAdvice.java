package com.example.restdemotask.exception;

import com.example.restdemotask.controller.UserController;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice(basePackageClasses =  UserController.class)
public class ValidationExceptionAdvice {

    @ExceptionHandler(AgeValidationException.class)
    public ResponseEntity<Object> handleAgeValidationException(){
        return new ResponseEntity<>("please check valid age more than 18", new HttpHeaders(), HttpStatus.FORBIDDEN);
    }

    @ExceptionHandler(DateRangeValidationException.class)
    public ResponseEntity<Object> handleDateRangeValidationException(){
        return new ResponseEntity<>("please check date from before date to", new HttpHeaders(), HttpStatus.FORBIDDEN);
    }
}
