package com.todo.todoapp.dto;

import com.todo.todoapp.entity.Task.Statut;
import lombok.Data;

@Data
public class TaskDTO {
    private Long id;
    private String titre;
    private String description;
    private Statut statut;
}