package hu.zimikri.todoapp.services;

import hu.zimikri.todoapp.controllers.exceptions.*;
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
    public AllTodosByUserDTO findAllTodosByUser(long userId) throws RuntimeException {
        if (!userRepository.existsUserById(userId)) throw new UserNotFoundException();

        return new AllTodosByUserDTO(todoRepository.findAllByUserId(userId));
    }

    @Override
    public TodoDTO findTodoById(long todoId, long userId) throws RuntimeException {
        if (!userRepository.existsUserById(userId)) throw new UserNotFoundException();
        Todo todo = todoRepository.findTodoById(todoId)
                .orElseThrow(TodoNotFoundException::new);
        if (todo.getUserId() != userId) throw new UserNotOwnTodoException();

        return new TodoDTO(todo);
    }

    @Override
    public TodoDTO saveNewTodo(Todo todo, long userId) throws RuntimeException {
        if (!userRepository.existsUserById(userId)) throw new UserNotFoundException();

        if (todo.getTask() == null || todo.getTask().trim() == "" || !todo.getDeadline().matches("[0-9]{4}-[01][0-9]-[0-9]{2}"))
            throw new InvalidArgumentException();

        todo.setUserId(userId);
        return new TodoDTO(todoRepository.save(todo));
    }

    @Override
    public ApiStatusDTO deleteTodoById(long todoId, long userId) throws RuntimeException {
        if (!userRepository.existsUserById(userId)) throw new UserNotFoundException();
        Todo todo = todoRepository.findTodoById(todoId)
                .orElseThrow(TodoNotFoundException::new);

        if (todo.getUserId() != userId) throw new UserNotOwnTodoException();

        todoRepository.deleteById(todoId);
        return ApiStatusDTO.ok("Todo successfully deleted.");
    }

    @Override
    public TodoDTO updateTodo(Todo todo, long userId, long todoId) throws RuntimeException {
        if (todo.getId() != todoId || todo.getId() <= 0L || todoId <= 0L)
            throw new InvalidArgumentException();

        Todo originalTodo = todoRepository.findTodoById(todoId)
                .orElseThrow(TodoNotFoundException::new);
        if (originalTodo.getUserId() != userId) throw new UserNotOwnTodoException();

        // Set undefined properties to original
        todo.setTask(todo.getTask() == null ? originalTodo.getTask() : todo.getTask());
        todo.setUserId(todo.getUserId() == 0L ? originalTodo.getUserId() : todo.getUserId());
        todo.setDeadline(todo.getDeadline() == null ? originalTodo.getDeadline() : todo.getDeadline());
        todo.setPriority(todo.getPriority() == null ? originalTodo.getPriority() : todo.getPriority());
        todo.setCompleted((!todo.isCompleted() || todo.isCompleted()) ? todo.isCompleted() : originalTodo.isCompleted());

        return saveNewTodo(todo, userId);
    }
}
