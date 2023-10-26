package fatec.ams.todo.repositories;

import fatec.ams.todo.models.Todo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface TodoRepository extends JpaRepository<Todo, UUID> { }
