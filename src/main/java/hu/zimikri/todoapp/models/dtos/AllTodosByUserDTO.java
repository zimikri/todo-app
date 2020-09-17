package hu.zimikri.todoapp.models.dtos;

import hu.zimikri.todoapp.models.Entities.Todo;

import java.util.List;
import java.util.stream.Collectors;

public class AllTodosByUserDTO {
    private List<TodoDTO> todos;

    public AllTodosByUserDTO(List<Todo> todos) {
        this.setTodos(todos);
    }

    public List<TodoDTO> getTodos() {
        return todos;
    }

    public void setTodos(List<Todo> todos) {
        this.todos = todos.stream()
                .map(todo -> new TodoDTO(todo))
                .collect(Collectors.toList());
    }
}
