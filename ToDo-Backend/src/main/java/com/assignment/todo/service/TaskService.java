package com.assignment.todo.service;

import com.assignment.todo.dto.TaskDto;
import java.util.List;

public interface TaskService {
    TaskDto createTask(TaskDto taskDto);
    TaskDto markTaskAsCompleted(long id);
    List<TaskDto> getAllTasks();
}
