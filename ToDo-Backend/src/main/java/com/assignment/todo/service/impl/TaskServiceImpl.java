package com.assignment.todo.service.impl;

import com.assignment.todo.dto.TaskDto;
import com.assignment.todo.entity.Task;
import com.assignment.todo.mapper.TaskMapper;
import com.assignment.todo.repository.TaskRepository;
import com.assignment.todo.service.TaskService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class TaskServiceImpl implements TaskService {

    private final TaskRepository taskRepository;

    @Override
    public TaskDto createTask(TaskDto taskDto) {
        Task task = TaskMapper.toEntity(taskDto);
        task.setCreatedAt(LocalDateTime.now()); // Auto-set createdAt
        Task savedTask = taskRepository.save(task);
        return TaskMapper.toDto(savedTask);
    }

    @Override
    public TaskDto markTaskAsCompleted(long id) {
        Task task = taskRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Task not found with id: " + id));

        if (!task.isCompleted()) {
            task.setCompleted(true);
            task.setCompletedAt(LocalDateTime.now());
            taskRepository.save(task);
        }

        return TaskMapper.toDto(task);
    }

    @Override
    public List<TaskDto> getAllTasks() {
        return taskRepository.findAll()
                .stream()
                .map(TaskMapper::toDto)
                .collect(Collectors.toList());
    }
}
