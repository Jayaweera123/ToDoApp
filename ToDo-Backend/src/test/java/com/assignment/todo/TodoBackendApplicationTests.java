package com.assignment.todo;

import com.assignment.todo.entity.Task;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class TodoBackendApplicationTests {

	@Test
	void contextLoads() {
	}

	@LocalServerPort
	private int port;

	private String baseUrl = "http://localhost";

	private static RestTemplate restTemplate;

	@Autowired
	private TestH2repository h2Repository;

	@BeforeAll
	public static void init() {
		restTemplate = new RestTemplate();
	}

	@BeforeEach
	public void setUp() {
		baseUrl = baseUrl.concat(":").concat(port + "").concat("/api/tasks");
	}

	// Test for Creating a Task
	@Test
	public void testCreateTask() {
		Task task = new Task();
		task.setTitle("Buy Groceries");
		task.setDescription("Purchase vegetables, fruits, and essentials for the week");
		task.setCreatedAt(LocalDateTime.now());

		Task response = restTemplate.postForObject(baseUrl, task, Task.class);

		assertNotNull(response);
		assertEquals("Buy Groceries", response.getTitle());
		assertEquals(1, h2Repository.findAll().size());
	}

	// Test for Getting All Tasks
	@Test
	@Sql(statements = "INSERT INTO task (id, title, description, created_at, completed, completed_at) " +
			"VALUES (1, 'Task 1', 'Description 1', NOW(), false, NULL);", executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
	@Sql(statements = "DELETE FROM task WHERE id=1", executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD)
	public void testGetRecentTasks() {
		List<Task> tasks = restTemplate.getForObject(baseUrl, List.class);
		assertNotNull(tasks);
		assertEquals(1, tasks.size());
	}

	// Test for Getting a Task by ID
	@Test
	@Sql(statements = "INSERT INTO task (id, title, description, created_at, completed, completed_at) " +
			"VALUES (2, 'Read Book', 'Read a novel', NOW(), false, NULL);", executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
	@Sql(statements = "DELETE FROM task WHERE id=2", executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD)
	public void testFindTaskById() {
		Task task = restTemplate.getForObject(baseUrl + "/{id}", Task.class, 2);

		assertNotNull(task);
		assertEquals(2, task.getId());
		assertEquals("Read Book", task.getTitle());
	}

	// Test for Updating a Task
	@Test
	@Sql(statements = "INSERT INTO task (id, title, description, created_at, completed, completed_at) " +
			"VALUES (3, 'Exercise', 'Workout for 30 mins', NOW(), false, NULL);", executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
	@Sql(statements = "DELETE FROM task WHERE id=3", executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD)
	public void testUpdateTask() {
		Task updatedTask = new Task();
		updatedTask.setTitle("Exercise Updated");
		updatedTask.setDescription("Workout for 1 hour");
		updatedTask.setCompleted(true);
		updatedTask.setCompletedAt(LocalDateTime.now());

		restTemplate.put(baseUrl + "/{id}", updatedTask, 3);

		Task taskFromDB = h2Repository.findById(3L).orElse(null);

		assertNotNull(taskFromDB);
		assertEquals("Exercise Updated", taskFromDB.getTitle());
		assertEquals(true, taskFromDB.isCompleted());
	}

	// Test for Deleting a Task
	@Test
	@Sql(statements = "INSERT INTO task (id, title, description, created_at, completed, completed_at) " +
			"VALUES (4, 'Test Task', 'To be deleted', NOW(), false, NULL);", executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
	public void testDeleteTask() {
		int recordCount = h2Repository.findAll().size();
		assertEquals(1, recordCount);

		restTemplate.delete(baseUrl + "/{id}", 4);

		assertEquals(0, h2Repository.findAll().size());
	}
}
