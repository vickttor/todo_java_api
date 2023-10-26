package fatec.ams.todo.services.interfaces;

import fatec.ams.todo.DTO.saveTodoDTO;
import fatec.ams.todo.exceptions.ResourceNotFoundException;
import fatec.ams.todo.models.Todo;

import java.util.List;
import java.util.UUID;

public interface ITodo {
    public List<Todo> findAll();
    public Todo findById(UUID id) throws ResourceNotFoundException;
    public Todo create(saveTodoDTO todo);
    public Todo update(UUID id, saveTodoDTO todo) throws ResourceNotFoundException;
    public UUID delete(UUID id);
}
