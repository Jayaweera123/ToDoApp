package com.assignment.todo.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TaskDto {
    private long id;
    private String title;
    private String description;
    private LocalDateTime createdAt;  // Use LocalDateTime, not Timestamp
    private LocalDateTime updatedAt;
    private boolean completed;
}