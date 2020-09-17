package hu.zimikri.todoapp.controllers;

import hu.zimikri.todoapp.controllers.exceptions.ApiException;
import hu.zimikri.todoapp.models.AllTodosByUserDto;
import hu.zimikri.todoapp.models.ApiStatusDto;
import hu.zimikri.todoapp.models.Todo;
import hu.zimikri.todoapp.models.TodoDto;
import hu.zimikri.todoapp.services.TodoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Map;

@RestController
public class TodoController {

    private TodoService todoService;

    public TodoController(TodoService todoService) {
        this.todoService = todoService;
    }

    @GetMapping("/api/todos")
    public ResponseEntity<AllTodosByUserDto> getAllTodos(@RequestHeader(value="userId") long userId)
            throws ApiException {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(todoService.findAllTodosByUser(userId));
    }

    @GetMapping("/api/todos/{todoId}")
    public ResponseEntity<TodoDto> getTodoById(@RequestHeader long userId, @PathVariable long todoId)
            throws ApiException {

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(todoService.findTodoById(todoId, userId));
        }

    @Transactional
    @DeleteMapping("/api/todos/{todoId}")
    public ResponseEntity<ApiStatusDto> deleteTodoById(@RequestHeader long userId, @PathVariable long todoId)
            throws ApiException {

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(todoService.deleteTodoById(todoId, userId));
    }

    @PostMapping("/api/todos")
    public ResponseEntity<TodoDto> addNewTodo(@RequestBody Todo todo, @RequestHeader(value="userId") long userId)
            throws ApiException {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(todoService.saveNewTodo(todo, userId));
    }
}
