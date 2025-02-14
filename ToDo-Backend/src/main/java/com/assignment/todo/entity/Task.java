package com.assignment.todo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;  // For LocalDateTime

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "task")

public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)  // Auto-increment ID
    private long id;
    private String tittle;// Tittle of the task
    private String description;// Description about the task

    private LocalDateTime created=LocalDateTime.now(); // Timestamp when the task is created
    private LocalDateTime updated=LocalDateTime.now();// Timestamp when the task is created

    private boolean completed = false;
}
