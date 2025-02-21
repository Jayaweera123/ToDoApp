package com.assignment.todo;

import com.assignment.todo.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TestH2repository extends JpaRepository<Task, Long> {
}
