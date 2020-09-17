package hu.zimikri.todoapp.services;

import hu.zimikri.todoapp.controllers.exceptions.ApiException;
import hu.zimikri.todoapp.models.dtos.AllTodosByUserDTO;
import hu.zimikri.todoapp.models.dtos.ApiStatusDTO;
import hu.zimikri.todoapp.models.Entities.Todo;
import hu.zimikri.todoapp.models.dtos.TodoDTO;

public interface TodoService {

    AllTodosByUserDTO findAllTodosByUser(long userId) throws ApiException;
    TodoDTO findTodoById(long todoId, long userId) throws ApiException;
    TodoDTO saveNewTodo(Todo todo, long userId) throws ApiException;
    ApiStatusDTO deleteTodoById(long todoId, long userId) throws ApiException;

}
