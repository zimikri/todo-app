package hu.zimikri.todoapp.models.dtos;

import hu.zimikri.todoapp.models.Entities.User;

public class UserMinDTO {
    private long id;
    private String username;

    public UserMinDTO(User user) {
        this.id = user.getId();
        this.username = user.getUsername();
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public long getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }
}
