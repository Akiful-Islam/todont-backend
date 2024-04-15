package com.ids.todont.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.util.Date;

@NoArgsConstructor(force = true)
@RequiredArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode
@Entity
public class Todo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NonNull
    @NotEmpty(message = "Title is required")
    private String title;
    @NonNull
    @NotEmpty
    private String description;
    @NonNull
    private Date dueDate;
    @NonNull
    @NotNull
    @Enumerated(EnumType.STRING)
    private Priority priority;
    @NonNull
    private boolean completed;
}
