package com.spring.springbootfeatures.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(value = ResourceNotFoundException.class)
    public ResponseEntity<Object> exception(ResourceNotFoundException exception) {
        return  new ResponseEntity<>(exception.getResourceName()+ " Resource Not Found with "+exception.getFieldValue(), HttpStatus.NOT_FOUND);
    }

}
