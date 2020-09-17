package hu.zimikri.todoapp.services;

import hu.zimikri.todoapp.models.Todo;
import hu.zimikri.todoapp.repositories.TodoRepository;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class TodoService implements TodoServiceInterface {

    public TodoRepository todoRepository;

    public TodoService(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    @Override
    public Map<String, List<Todo>> findAllTodosByUser(long userId) {
        Map<String, List<Todo>> result = new HashMap<>();
        result.put("todos", todoRepository.findAllByUserId(userId));
        return result;
    }

    @Override
    public Todo findTodoById(long id) {
        return null;
    }

    @Override
    public Todo saveNewTodo(Todo todo) {
        return todoRepository.save(todo);
    }
}
