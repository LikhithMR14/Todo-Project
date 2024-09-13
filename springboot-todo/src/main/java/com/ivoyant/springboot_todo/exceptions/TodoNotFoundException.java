package com.ivoyant.springboot_todo.exceptions;

public class TodoNotFoundException extends RuntimeException{

    public TodoNotFoundException(Long id) {
        super("Task not found with ID:" + id);
    }

}
