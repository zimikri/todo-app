package hu.zimikri.todoapp.repositories;


import hu.zimikri.todoapp.models.Entities.Todo;
import jdk.nashorn.internal.runtime.options.Option;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TodoRepository extends CrudRepository<Todo, Long> {
    Optional<Todo> findTodoById(long id);
    List<Todo> findAllByUserId(long userId);
    void deleteById(long id);
}
