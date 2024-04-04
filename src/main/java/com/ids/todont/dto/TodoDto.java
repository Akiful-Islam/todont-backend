package com.ids.todont.dto;

import com.ids.todont.entity.Priority;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

import java.util.Date;

public record TodoDto(
    Long id,
    @NotEmpty(message = "Title is required")
    String title,
    String description,
    @NotEmpty(message = "Due date is required")
    Date dueDate,
    @NotNull(message = "Priority is required")
    Priority priority
) {
}
