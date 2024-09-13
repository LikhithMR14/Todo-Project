package com.ivoyant.springboot_todo.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    private final ExceptionObject exceptionObject;

    public GlobalExceptionHandler(ExceptionObject exceptionObject) {
        this.exceptionObject = exceptionObject;
    }

    @ExceptionHandler(TodoNotFoundException.class)
    public ResponseEntity<ExceptionObject> todoNotFoundException(Exception e) {
        exceptionObject.setMessage(e.getMessage());
        exceptionObject.setStatusCode(HttpStatus.NOT_FOUND.value());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(exceptionObject);
    }

}
