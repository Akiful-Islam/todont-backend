package com.ids.todont.service;

import com.ids.todont.repository.TodoRepository;
import org.springframework.stereotype.Service;

@Service
public class TodoService {
    private final TodoRepository todoRepository;

    public TodoService(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }
    private Todo toEntity(TodoDto todoDto){
        return new Todo(
            todoDto.title(),
            todoDto.description(),
            todoDto.dueDate(),
            todoDto.priority(),
            todoDto.completed()
        );
    }

    private TodoDto toDto(Todo todo){
        return new TodoDto(
            todo.getId(),
            todo.getTitle(),
            todo.getDescription(),
            todo.getDueDate(),
            todo.getPriority(),
            todo.isCompleted()
        );
    }
}
