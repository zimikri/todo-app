package hu.zimikri.todoapp.services;

import hu.zimikri.todoapp.models.dtos.AllTodosByUserDTO;
import hu.zimikri.todoapp.models.dtos.ApiStatusDTO;
import hu.zimikri.todoapp.models.Entities.Todo;
import hu.zimikri.todoapp.models.dtos.TodoDTO;

public interface TodoService {

    AllTodosByUserDTO findAllTodosByUser(long userId) throws RuntimeException;
    TodoDTO findTodoById(long todoId, long userId) throws RuntimeException;
    TodoDTO saveNewTodo(Todo todo, long userId) throws RuntimeException;
    ApiStatusDTO deleteTodoById(long todoId, long userId) throws RuntimeException;
    TodoDTO updateTodo(Todo todo, long userId, long todoId) throws RuntimeException;
}
