package com.assignment.todo.service.impl;

import com.assignment.todo.dto.TaskDto;
import com.assignment.todo.entity.Task;
import com.assignment.todo.mapper.TaskMapper;
import com.assignment.todo.repository.TaskRepository;
import com.assignment.todo.service.TaskService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class TaskServiceImpl implements TaskService {

    private TaskRepository taskRepository;

    @Override
    public TaskDto createTask(TaskDto taskDto){

        Task task = TaskMapper.mapToTask(taskDto);
        Task savedTask = taskRepository.save(task);
        return TaskMapper.mapToTaskDto(savedTask);
    }
}
