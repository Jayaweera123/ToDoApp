package com.assignment.todo.controller;

import com.assignment.todo.dto.TaskDto;
import com.assignment.todo.service.TaskService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class TaskControllerTest {

    @Mock
    private TaskService taskService;

    @InjectMocks
    private TaskController taskController;

    private TaskDto taskDto;

    @BeforeEach
    void setUp() {
        taskDto = new TaskDto();
        taskDto.setId(1L);
        taskDto.setTitle("Test Task");
        taskDto.setDescription("Test Description");
    }

    @Test
    void createTask() {
        when(taskService.createTask(any(TaskDto.class))).thenReturn(taskDto);

        ResponseEntity<TaskDto> response = taskController.createTask(taskDto);

        assertNotNull(response.getBody());
        assertEquals(1L, response.getBody().getId());
        assertEquals("Test Task", response.getBody().getTitle());
        verify(taskService, times(1)).createTask(any(TaskDto.class));
    }

    @Test
    void getRecentTasks() {
        List<TaskDto> taskList = Arrays.asList(taskDto);
        when(taskService.getRecentTasks()).thenReturn(taskList);

        ResponseEntity<List<TaskDto>> response = taskController.getRecentTasks();

        assertNotNull(response.getBody());
        assertEquals(1, response.getBody().size());
        verify(taskService, times(1)).getRecentTasks();
    }

    @Test
    void getTaskById() {
        when(taskService.getTaskById(1L)).thenReturn(taskDto);

        ResponseEntity<TaskDto> response = taskController.getTaskById(1L);

        assertNotNull(response.getBody());
        assertEquals(1L, response.getBody().getId());
        verify(taskService, times(1)).getTaskById(1L);
    }

    @Test
    void updateTask() {
        TaskDto updatedTask = new TaskDto();
        updatedTask.setId(1L);
        updatedTask.setTitle("Updated Task");
        updatedTask.setDescription("Updated Description");

        when(taskService.updateTask(eq(1L), any(TaskDto.class))).thenReturn(updatedTask);

        ResponseEntity<TaskDto> response = taskController.updateTask(1L, updatedTask);

        assertNotNull(response.getBody());
        assertEquals("Updated Task", response.getBody().getTitle());
        verify(taskService, times(1)).updateTask(eq(1L), any(TaskDto.class));
    }

    @Test
    void deleteTask() {
        doNothing().when(taskService).deleteTask(1L);

        ResponseEntity<String> response = taskController.deleteTask(1L);

        assertNotNull(response.getBody());
        assertEquals("Task deleted successfully", response.getBody());
        verify(taskService, times(1)).deleteTask(1L);
    }
}
