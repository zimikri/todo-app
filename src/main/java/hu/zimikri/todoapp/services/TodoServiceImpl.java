package hu.zimikri.todoapp.services;

import hu.zimikri.todoapp.controllers.exceptions.ApiException;
import hu.zimikri.todoapp.controllers.exceptions.TodoNotFoundException;
import hu.zimikri.todoapp.controllers.exceptions.UserNotFoundException;
import hu.zimikri.todoapp.controllers.exceptions.UserNotOwnTodo;
import hu.zimikri.todoapp.models.AllTodosByUserDto;
import hu.zimikri.todoapp.models.ApiStatusDto;
import hu.zimikri.todoapp.models.Todo;
import hu.zimikri.todoapp.models.TodoDto;
import hu.zimikri.todoapp.repositories.TodoRepository;
import hu.zimikri.todoapp.repositories.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class TodoServiceImpl implements TodoService {

    public TodoRepository todoRepository;
    public UserRepository userRepository;

    public TodoServiceImpl(TodoRepository todoRepository, UserRepository userRepository) {
        this.todoRepository = todoRepository;
        this.userRepository = userRepository;
    }

    @Override
    public AllTodosByUserDto findAllTodosByUser(long userId) throws ApiException {
        if (!userRepository.existsUserById(userId)) throw new UserNotFoundException();

        return new AllTodosByUserDto(todoRepository.findAllByUserId(userId));
    }

    @Override
    public TodoDto findTodoById(long todoId, long userId) throws ApiException {
        if (!userRepository.existsUserById(userId)) throw new UserNotFoundException();
        Todo todo = todoRepository.findTodoById(todoId);

        if (todo == null) throw new TodoNotFoundException();
        if (todo.getUserId() != userId) throw new UserNotOwnTodo();

        return new TodoDto(todo);
    }

    @Override
    public TodoDto saveNewTodo(Todo todo, long userId) throws ApiException {
        if (!userRepository.existsUserById(userId)) throw new UserNotFoundException();
        // TODO: Data validation
        todo.setUserId(userId);
        return new TodoDto(todoRepository.save(todo));
    }

    @Override
    public ApiStatusDto deleteTodoById(long todoId, long userId) throws ApiException {
        if (!userRepository.existsUserById(userId)) throw new UserNotFoundException();
        Todo todo = todoRepository.findTodoById(todoId);

        if (todo == null) throw new TodoNotFoundException();
        if (todo.getUserId() != userId) throw new UserNotOwnTodo();

        todoRepository.deleteById(todoId);
        return ApiStatusDto.ok("Todo successfully deleted.");
    }
}
