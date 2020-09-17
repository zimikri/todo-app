package hu.zimikri.todoapp.controllers;

import hu.zimikri.todoapp.controllers.exceptions.ApiException;
import hu.zimikri.todoapp.models.dtos.AllTodosByUserDTO;
import hu.zimikri.todoapp.models.dtos.ApiStatusDTO;
import hu.zimikri.todoapp.models.Entities.Todo;
import hu.zimikri.todoapp.models.dtos.TodoDTO;
import hu.zimikri.todoapp.services.TodoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;

@RestController
public class TodoController {

    private TodoService todoService;

    public TodoController(TodoService todoService) {
        this.todoService = todoService;
    }

    @GetMapping("/api/todos")
    public ResponseEntity<AllTodosByUserDTO> getAllTodos(@RequestHeader(value="userId") long userId)
            throws ApiException {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(todoService.findAllTodosByUser(userId));
    }

    @GetMapping("/api/todos/{todoId}")
    public ResponseEntity<TodoDTO> getTodoById(@RequestHeader long userId, @PathVariable long todoId)
            throws ApiException {

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(todoService.findTodoById(todoId, userId));
        }

    @Transactional
    @DeleteMapping("/api/todos/{todoId}")
    public ResponseEntity<ApiStatusDTO> deleteTodoById(@RequestHeader long userId, @PathVariable long todoId)
            throws ApiException {

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(todoService.deleteTodoById(todoId, userId));
    }

    @PostMapping("/api/todos")
    public ResponseEntity<TodoDTO> addNewTodo(@RequestBody Todo todo, @RequestHeader(value="userId") long userId)
            throws ApiException {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(todoService.saveNewTodo(todo, userId));
    }
}
