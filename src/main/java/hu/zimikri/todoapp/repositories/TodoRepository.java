package hu.zimikri.todoapp.repositories;


import hu.zimikri.todoapp.models.Todo;
import hu.zimikri.todoapp.models.TodoDto;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TodoRepository extends CrudRepository<Todo, Integer> {
//    List<TodoDto> findAll();
    Todo findTodoById(long id);
    List<Todo> findAllByUserId(long userId);
    void deleteById(long id);
}
