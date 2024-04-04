package com.ids.todont.service;

import com.ids.todont.dto.TodoDto;
import com.ids.todont.entity.Todo;
import com.ids.todont.repository.TodoRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class TodoService {
    private final TodoRepository todoRepository;

    public TodoService(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    public Page<TodoDto> findAll(Pageable pageable) {
        return todoRepository.findAll(pageable).map(this::toDto);
    }

    public TodoDto findTodoById(Long id) {
        return todoRepository.findById(id).map(this::toDto).orElseThrow(
            () -> new IllegalArgumentException("Todo with id " + id + " not found")
        );
    }

    public TodoDto save(TodoDto todoDto) {
        return toDto(todoRepository.save(toEntity(todoDto)));
    }

    public TodoDto update(Long id, TodoDto todoDto) {
        Todo todo = todoRepository.findById(id).orElseThrow(
            () -> new IllegalArgumentException("Todo with id " + id + " not found")
        );
        todo.setTitle(todoDto.title());
        todo.setDescription(todoDto.description());
        todo.setDueDate(todoDto.dueDate());
        todo.setPriority(todoDto.priority());
        todo.setCompleted(todoDto.completed());
        return toDto(todoRepository.save(todo));
    }

    public void delete(Long id) {
        todoRepository.findById(id).ifPresentOrElse(
                todoRepository::delete,
            () -> {
                throw new IllegalArgumentException("Todo with id " + id + " not found");
            }
        );
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
