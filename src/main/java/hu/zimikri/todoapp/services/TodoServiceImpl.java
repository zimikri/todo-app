package hu.zimikri.todoapp.services;

import hu.zimikri.todoapp.controllers.exceptions.ApiException;
import hu.zimikri.todoapp.controllers.exceptions.TodoNotFoundException;
import hu.zimikri.todoapp.controllers.exceptions.UserNotFoundException;
import hu.zimikri.todoapp.controllers.exceptions.UserNotOwnTodoException;
import hu.zimikri.todoapp.models.dtos.AllTodosByUserDTO;
import hu.zimikri.todoapp.models.dtos.ApiStatusDTO;
import hu.zimikri.todoapp.models.Entities.Todo;
import hu.zimikri.todoapp.models.dtos.TodoDTO;
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
    public AllTodosByUserDTO findAllTodosByUser(long userId) throws ApiException {
        if (!userRepository.existsUserById(userId)) throw new UserNotFoundException();

        return new AllTodosByUserDTO(todoRepository.findAllByUserId(userId));
    }

    @Override
    public TodoDTO findTodoById(long todoId, long userId) throws ApiException {
        if (!userRepository.existsUserById(userId)) throw new UserNotFoundException();
        Todo todo = todoRepository.findTodoById(todoId);

        if (todo == null) throw new TodoNotFoundException();
        if (todo.getUserId() != userId) throw new UserNotOwnTodoException();

        return new TodoDTO(todo);
    }

    @Override
    public TodoDTO saveNewTodo(Todo todo, long userId) throws ApiException {
        if (!userRepository.existsUserById(userId)) throw new UserNotFoundException();
        // TODO: Data validation
        todo.setUserId(userId);
        return new TodoDTO(todoRepository.save(todo));
    }

    @Override
    public ApiStatusDTO deleteTodoById(long todoId, long userId) throws ApiException {
        if (!userRepository.existsUserById(userId)) throw new UserNotFoundException();
        Todo todo = todoRepository.findTodoById(todoId);

        if (todo == null) throw new TodoNotFoundException();
        if (todo.getUserId() != userId) throw new UserNotOwnTodoException();

        todoRepository.deleteById(todoId);
        return ApiStatusDTO.ok("Todo successfully deleted.");
    }
}
