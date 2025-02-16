package com.assignment.todo.mapper;

import com.assignment.todo.dto.TaskDto;
import com.assignment.todo.entity.Task;

public class TaskMapper {

    public static TaskDto toDto(Task task) {
        return new TaskDto(
                task.getId(),
                task.getTitle(),
                task.getDescription(),
                task.getCreatedAt(),
                task.getCompletedAt(),
                task.isCompleted()
        );
    }

    public static Task toEntity(TaskDto taskDto) {
        Task task = new Task();
        task.setTitle(taskDto.getTitle());
        task.setDescription(taskDto.getDescription());
        return task;
    }
}
