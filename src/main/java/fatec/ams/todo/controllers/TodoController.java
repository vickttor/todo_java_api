package fatec.ams.todo.controllers;

import fatec.ams.todo.DTO.saveTodoDTO;
import fatec.ams.todo.exceptions.ResourceNotFoundException;
import fatec.ams.todo.models.Todo;
import fatec.ams.todo.services.impl.TodoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/todos")
@RequiredArgsConstructor
public class TodoController {

    private final TodoService service;

    @GetMapping("")
    public ResponseEntity<List<Todo>> findAllTodo() {
        return ResponseEntity.status(HttpStatus.OK).body(service.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable UUID id) throws ResourceNotFoundException {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(service.findById(id));
        }catch(Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Tarefa não encontrada");
        }
    }

    @PostMapping("")
    public ResponseEntity<Todo> createTodo(@RequestBody saveTodoDTO newTodo) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.create(newTodo));
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateTodo(@PathVariable UUID id, @RequestBody saveTodoDTO oldTodo) {
        try {
            service.update(id, oldTodo);
            return ResponseEntity.status(HttpStatus.OK).body("Tarefa Atualizada");
        }catch(Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Tarefa não encontrada");
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteTodo(@PathVariable UUID id){
        service.delete(id);
        return ResponseEntity.status(HttpStatus.OK).body("Tarefa deletada");
    }

}
