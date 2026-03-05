package com.todo.todoapp.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class TaskRequestDTO {
    @NotBlank(message = "Le titre est obligatoire")
    private String titre;

    private String description;
}