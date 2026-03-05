package com.todo.todoapp.controller;

import com.todo.todoapp.dto.TaskDTO;
import com.todo.todoapp.dto.TaskRequestDTO;
import com.todo.todoapp.service.TaskService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tasks")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class TaskController {

    private final TaskService taskService;

    @PostMapping
    public ResponseEntity<TaskDTO> createTask(@Valid @RequestBody TaskRequestDTO requestDTO) {
        return new ResponseEntity<>(taskService.createTask(requestDTO), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<TaskDTO>> getAllTasks() {
        return ResponseEntity.ok(taskService.getAllTasks());
    }

    @GetMapping("/{id}")
    public ResponseEntity<TaskDTO> getTaskById(@PathVariable Long id) {
        return ResponseEntity.ok(taskService.getTaskById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<TaskDTO> updateTask(@PathVariable Long id,
                                              @Valid @RequestBody TaskRequestDTO requestDTO) {
        return ResponseEntity.ok(taskService.updateTask(id, requestDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTask(@PathVariable Long id) {
        taskService.deleteTask(id);
        return ResponseEntity.noContent().build();
    }

    @PatchMapping("/{id}/complete")
    public ResponseEntity<TaskDTO> markAsCompleted(@PathVariable Long id) {
        return ResponseEntity.ok(taskService.markAsCompleted(id));
    }
}
