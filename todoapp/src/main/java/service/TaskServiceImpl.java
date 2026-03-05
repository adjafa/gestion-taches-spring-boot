package com.todo.todoapp.service;

import com.todo.todoapp.dto.TaskDTO;
import com.todo.todoapp.dto.TaskRequestDTO;
import com.todo.todoapp.entity.Task;
import com.todo.todoapp.mapper.TaskMapper;
import com.todo.todoapp.repository.TaskRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional
public class TaskServiceImpl implements TaskService {

    private final TaskRepository taskRepository;
    private final TaskMapper taskMapper;

    @Override
    public TaskDTO createTask(TaskRequestDTO requestDTO) {
        Task task = taskMapper.toEntity(requestDTO);
        Task savedTask = taskRepository.save(task);
        return taskMapper.toDTO(savedTask);
    }

    @Override
    @Transactional(readOnly = true)
    public List<TaskDTO> getAllTasks() {
        return taskRepository.findAll()
                .stream()
                .map(taskMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional(readOnly = true)
    public TaskDTO getTaskById(Long id) {
        Task task = taskRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Tâche non trouvée avec l'id: " + id));
        return taskMapper.toDTO(task);
    }

    @Override
    public TaskDTO updateTask(Long id, TaskRequestDTO requestDTO) {
        Task task = taskRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Tâche non trouvée avec l'id: " + id));
        taskMapper.updateEntityFromDTO(requestDTO, task);
        Task updatedTask = taskRepository.save(task);
        return taskMapper.toDTO(updatedTask);
    }

    @Override
    public void deleteTask(Long id) {
        if (!taskRepository.existsById(id)) {
            throw new EntityNotFoundException("Tâche non trouvée avec l'id: " + id);
        }
        taskRepository.deleteById(id);
    }

    @Override
    public TaskDTO markAsCompleted(Long id) {
        Task task = taskRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Tâche non trouvée avec l'id: " + id));
        task.setStatut(Task.Statut.TERMINE);
        Task updatedTask = taskRepository.save(task);
        return taskMapper.toDTO(updatedTask);
    }
}