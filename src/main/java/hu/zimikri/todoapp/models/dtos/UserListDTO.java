package hu.zimikri.todoapp.models.dtos;

import hu.zimikri.todoapp.models.Entities.User;

import java.util.List;
import java.util.stream.Collectors;

public class UserListDTO {
    private List<UserMinDTO> users;

    public UserListDTO(List<User> userList) {
        this.setUsers(userList);
    }

    public List<UserMinDTO> getUsers() {
        return users;
    }

    public void setUsers(List<User> userList) {
        users = userList.stream()
        .map(user -> new UserMinDTO(user))
        .collect(Collectors.toList());
    }
}
