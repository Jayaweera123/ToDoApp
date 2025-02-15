package com.assignment.todo.entity;

import jakarta.persistence.*;
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

    @Column(name = "tittle")
    private String tittle;// Tittle of the task

    @Column(name = "description")
    private String description;// Description about the task

    @Column(name = "created")
    private LocalDateTime created=LocalDateTime.now(); // Timestamp when the task is created

    @Column(name = "updated")
    private LocalDateTime updated=LocalDateTime.now();// Timestamp when the task is created

    @Column(name ="completed")
    private boolean completed = false;
}
