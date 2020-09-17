package hu.zimikri.todoapp.models;

import java.util.List;

public class UserTodosDto {
    private long id;
    private String username;
    private List<TodoDto> todos;

    public UserTodosDto() {
    }

    public UserTodosDto(long id, String username, List<Todo> todos) {
        this.id = id;
        this.username = username;
        this.setTodos(todos);
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setTodos(List<Todo> todos) {
        this.todos = new AllTodosByUserDto(todos).getTodos();
    }

    public long getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public List<TodoDto> getTodos() {
        return todos;
    }
}
