package com.todo.todoapp.service;

import com.todo.todoapp.dto.TaskDTO;
import com.todo.todoapp.dto.TaskRequestDTO;
import java.util.List;

public interface TaskService {
    TaskDTO createTask(TaskRequestDTO requestDTO);
    List<TaskDTO> getAllTasks();
    TaskDTO getTaskById(Long id);
    TaskDTO updateTask(Long id, TaskRequestDTO requestDTO);
    void deleteTask(Long id);
    TaskDTO markAsCompleted(Long id);
}
