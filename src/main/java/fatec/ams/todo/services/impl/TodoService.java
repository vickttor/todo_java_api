package fatec.ams.todo.services.impl;

import fatec.ams.todo.DTO.saveTodoDTO;
import fatec.ams.todo.exceptions.ResourceNotFoundException;
import fatec.ams.todo.models.Todo;
import fatec.ams.todo.repositories.TodoRepository;
import fatec.ams.todo.services.interfaces.ITodo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@RequiredArgsConstructor
@Service
public class TodoService implements ITodo {

    private final TodoRepository repository;

    @Override
    public List<Todo> findAll() {
        return repository.findAll();
    }

    @Override
    public Todo findById(UUID id) throws ResourceNotFoundException {
        return repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Tarefa não encontrada"));
    }


    @Override
    public Todo update(UUID id, saveTodoDTO todo) throws  ResourceNotFoundException{
        Todo existingTodo = repository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Essa tarefa não pode ser atualizada."));

        existingTodo.setName(todo.getName());
        existingTodo.setDescription(todo.getDescription());
        existingTodo.setChecked(todo.isChecked());
        existingTodo.setPriority(todo.getPriority());
        existingTodo.setResponsible(todo.getResponsible());

        return repository.save(existingTodo);
    }

    @Override
    public Todo create(saveTodoDTO todo) {
        Todo todoToBeCreated = Todo.builder()
                .name(todo.getName())
                .description(todo.getDescription())
                .checked(todo.isChecked())
                .priority(todo.getPriority())
                .responsible(todo.getResponsible())
                .build();

        return repository.save(todoToBeCreated);
    }

    @Override
    public UUID delete(UUID id) {
        repository.deleteById(id);
        return id;
    }
}
