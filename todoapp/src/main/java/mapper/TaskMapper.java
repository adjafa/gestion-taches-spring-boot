package com.todo.todoapp.mapper;

import com.todo.todoapp.dto.TaskDTO;
import com.todo.todoapp.dto.TaskRequestDTO;
import com.todo.todoapp.entity.Task;
import org.springframework.stereotype.Component;

@Component
public class TaskMapper {

    public TaskDTO toDTO(Task task) {
        TaskDTO dto = new TaskDTO();
        dto.setId(task.getId());
        dto.setTitre(task.getTitre());
        dto.setDescription(task.getDescription());
        dto.setStatut(task.getStatut());
        return dto;
    }

    public Task toEntity(TaskRequestDTO requestDTO) {
        Task task = new Task();
        task.setTitre(requestDTO.getTitre());
        task.setDescription(requestDTO.getDescription());
        return task;
    }

    public void updateEntityFromDTO(TaskRequestDTO dto, Task task) {
        task.setTitre(dto.getTitre());
        task.setDescription(dto.getDescription());
    }
}