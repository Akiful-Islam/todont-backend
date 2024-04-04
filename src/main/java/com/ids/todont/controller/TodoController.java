package com.ids.todont.controller;

import com.ids.todont.dto.TodoDto;
import com.ids.todont.service.TodoService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/todos")
public class TodoController {
    private final TodoService todoService;

    public TodoController(TodoService todoService) {
        this.todoService = todoService;
    }

    @GetMapping
    public ResponseEntity<Page<TodoDto>> findAllTodos(Pageable pageable){
        return ResponseEntity.ok(todoService.findAll(pageable));
    }

    @GetMapping("/{id}")
    public ResponseEntity<TodoDto> findTodoById(@PathVariable Long id){
        return ResponseEntity.ok(todoService.findTodoById(id));
    }

    @PostMapping
    public ResponseEntity<TodoDto> save(@RequestBody TodoDto todoDto){
        return ResponseEntity.ok(todoService.save(todoDto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<TodoDto> update(@PathVariable Long id, @RequestBody TodoDto todoDto){
        return ResponseEntity.ok(todoService.update(id, todoDto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        todoService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
