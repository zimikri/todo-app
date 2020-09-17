package hu.zimikri.todoapp.models;

import java.util.List;
import java.util.stream.Collectors;

public class AllTodosByUserDto {
    private List<TodoDto> todos;

    public AllTodosByUserDto(List<Todo> todos) {
        this.setTodos(todos);
    }

    public List<TodoDto> getTodos() {
        return todos;
    }

    public void setTodos(List<Todo> todos) {
        this.todos = todos.stream()
                .map(todo -> new TodoDto(todo))
                .collect(Collectors.toList());
    }
}
