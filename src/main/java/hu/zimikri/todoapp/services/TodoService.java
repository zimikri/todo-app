package hu.zimikri.todoapp.services;

import hu.zimikri.todoapp.controllers.exceptions.ApiException;
import hu.zimikri.todoapp.models.AllTodosByUserDto;
import hu.zimikri.todoapp.models.ApiStatusDto;
import hu.zimikri.todoapp.models.Todo;
import hu.zimikri.todoapp.models.TodoDto;

public interface TodoService {

    AllTodosByUserDto findAllTodosByUser(long userId) throws ApiException;
    TodoDto findTodoById(long todoId, long userId) throws ApiException;
    TodoDto saveNewTodo(Todo todo, long userId) throws ApiException;
    ApiStatusDto deleteTodoById(long todoId, long userId) throws ApiException;

}
