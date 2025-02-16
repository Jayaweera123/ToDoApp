package com.assignment.todo.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "task") // Name of database table
@EntityListeners(AuditingEntityListener.class) // Enables auditing for auto timestamps
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)  // Auto-increment ID
    private long id;

    @Column(name = "title", nullable = false)
    private String title; // Title of the task

    @Column(name = "description", nullable = false)
    private String description; // Description about the task

    @CreatedDate // Automatically set when the entity is created
    @Column(name = "createdAt", nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @Column(name = "completedAt")
    private LocalDateTime completedAt;

    @Column(name = "completed", nullable = false)
    private boolean completed = false;
}
