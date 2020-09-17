package hu.zimikri.todoapp.repositories;


import hu.zimikri.todoapp.models.Entities.Todo;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TodoRepository extends CrudRepository<Todo, Long> {
//    List<TodoDto> findAll();
    Todo findTodoById(long id);
    List<Todo> findAllByUserId(long userId);
    void deleteById(long id);
}
