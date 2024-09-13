package com.ivoyant.springboot_todo.controller;



import com.ivoyant.springboot_todo.model.Todo;
import com.ivoyant.springboot_todo.service.TodoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/todos")
public class TodoController {

    private final TodoService todoService;

    public TodoController(TodoService todoService) {
        this.todoService = todoService;
    }

    @GetMapping("/")
    public ResponseEntity<List<Todo>> getAllTodos() {
        List<Todo> allTodos = todoService.getAllTodos();
        return allTodos.isEmpty() ? new ResponseEntity<>(HttpStatus.NO_CONTENT) : new ResponseEntity<>(allTodos, HttpStatus.OK);
    }

    @GetMapping("/completed/{isCompleted}")
    public ResponseEntity<List<Todo>> getAllCompletedTodos(@PathVariable boolean isCompleted) {
        List<Todo> allCompletedTodos = todoService.getAllCompletedTodos(isCompleted);
        return allCompletedTodos.isEmpty() ? new ResponseEntity<>(HttpStatus.NO_CONTENT) : new ResponseEntity<>(allCompletedTodos, HttpStatus.OK);
    }

    @PostMapping("/")
    public ResponseEntity<String> addTodo(@Valid @RequestBody Todo newTodo) {
        Todo addedTodo = todoService.addTodo(newTodo);
        return new ResponseEntity<>("New Todo Has Been Created :)", HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> replaceTodo(@PathVariable Long id, @RequestBody Todo newTodo) {
        boolean isUpdated = todoService.replaceTodo(id, newTodo);
        return isUpdated ? new ResponseEntity<>("Task Updated", HttpStatus.OK) : new ResponseEntity<>("Task Created", HttpStatus.CREATED);
    }

    @PatchMapping("/complete/{id}")
    public ResponseEntity<String> completeTodo(@PathVariable Long id) {
        boolean completed = todoService.completeTodo(id);
        return completed ? new ResponseEntity<>("Task marked as completed", HttpStatus.OK) : new ResponseEntity<>("Task not found", HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteTodo(@PathVariable Long id) {
        boolean removed = todoService.deleteTodo(id);
        return removed ? new ResponseEntity<>("Task deleted", HttpStatus.OK) : new ResponseEntity<>("Task not found", HttpStatus.NOT_FOUND);
    }

}

