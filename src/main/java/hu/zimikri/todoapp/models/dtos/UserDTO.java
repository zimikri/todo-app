package hu.zimikri.todoapp.models.dtos;

import hu.zimikri.todoapp.models.Entities.Todo;
import hu.zimikri.todoapp.models.Entities.User;

import java.util.List;

public class UserDTO {
    private long id;
    private String username;
    private List<TodoDTO> todos;

    public UserDTO(User user, List<Todo> todos) {
        this.id = user.getId();
        this.username = user.getUsername();
        this.setTodos(todos);
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setTodos(List<Todo> todos) {
        this.todos = new AllTodosByUserDTO(todos).getTodos();
    }

    public long getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public List<TodoDTO> getTodos() {
        return todos;
    }
}
