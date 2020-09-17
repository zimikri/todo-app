package hu.zimikri.todoapp.services;

import hu.zimikri.todoapp.models.Todo;

import java.util.List;
import java.util.Map;

public interface TodoServiceInterface {

    Map<String, List<Todo>> findAllTodosByUser(long userId);
    Todo findTodoById(long id);
    Todo saveNewTodo(Todo todo);
}
