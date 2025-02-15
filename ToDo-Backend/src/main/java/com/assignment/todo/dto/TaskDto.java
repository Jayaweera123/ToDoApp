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
public class EmployeeDto {
    private long id;
    private String tittle;// Tittle of the task
    private String description;// Description about the task
    private LocalDateTime created=LocalDateTime.now(); // Timestamp when the task is created
    private LocalDateTime updated=LocalDateTime.now();// Timestamp when the task is created
    private boolean completed = false;
}

}
