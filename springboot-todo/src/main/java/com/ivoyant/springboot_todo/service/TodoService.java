package com.ivoyant.springboot_todo.service;


import com.ivoyant.springboot_todo.exceptions.TodoNotFoundException;
import com.ivoyant.springboot_todo.model.Todo;
import com.ivoyant.springboot_todo.repository.TodoRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class TodoService {

    private final TodoRepository todos;

    public TodoService(TodoRepository todos) {
        this.todos = todos;
    }

//    Logger logger= LoggerFactory.getLogger(TodoService.class);

    public List<Todo> getAllTodos() {
//        logger.error("used Logger instance to log this");
//        log.error("used slf4j annotation to log this");
//        log.info("used slf4j annotation to log this");
        return todos.findAll();
    }

    public List<Todo> getAllCompletedTodos(boolean isCompleted) {
        return todos.findByCompleted(isCompleted);
    }

    public Todo addTodo(Todo newTodo) {
        return todos.save(newTodo);
    }

    public boolean replaceTodo(Long id, Todo newTodo) {
        boolean isExists = todos.existsById(id);
        if (!isExists) {
            todos.save(newTodo);
            return false;
        } else {
            Todo replacableTodo = todos.findById(id).orElse(null);
            assert replacableTodo != null;
            replacableTodo.setDescription(newTodo.getDescription());
            replacableTodo.setCompleted(newTodo.isCompleted());
            replacableTodo.setPriority(newTodo.getPriority());
            todos.save(replacableTodo);
            return true;
        }
    }

    public boolean deleteTodo(Long id) {
        log.info("This following ID has been deleted : {}", id);
        if (!todos.existsById(id)) {
            throw new TodoNotFoundException(id);
        } else {
            todos.deleteById(id);
            return true;
        }
    }

    public boolean completeTodo(Long id) {
        Todo updateTodo = todos.findById(id).orElseThrow(() -> new TodoNotFoundException(id));
            updateTodo.setCompleted(true);
            todos.save(updateTodo);
        return true;
    }

}

