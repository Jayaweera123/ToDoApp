package com.assignment.todo.mapper;

import com.assignment.todo.dto.TaskDto;
import com.assignment.todo.entity.Task;

public class TaskMapper {

    // Converts a Task entity to a TaskDto
    public static TaskDto mapToTaskDto(Task task) {
        if (task == null) {
            return null;  // Handle null task: return null DTO if the task is null
        }
        return new TaskDto(
                task.getId(),
                task.getTittle(),
                task.getDescription(),
                task.getCreated(),
                task.getUpdated(),
                task.isCompleted()
        );
    }

    public static Task mapToTask(TaskDto taskDto) {
        if (taskDto == null) {
            return null;  // Handle null taskDto
        }
        return new Task(
                taskDto.getId(),
                taskDto.getTitle(),
                taskDto.getDescription(),
                taskDto.getCreatedAt(),
                taskDto.getUpdatedAt(),
                taskDto.isCompleted()


        );
    }
}