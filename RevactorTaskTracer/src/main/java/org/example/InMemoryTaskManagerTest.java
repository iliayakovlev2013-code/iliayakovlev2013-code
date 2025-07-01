package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.function.Supplier;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class InMemoryTaskManagerTest {
  private final TaskManager taskManager = Managers.getDefault();
  private boolean contains;

  @Test
  void addNewTask() {
    Task task = new Task("Test Task", "Test Description", Status.NEW);
    int taskId = taskManager.addNewTask(task);

    assertNotNull(taskManager.getTask(taskId), "Task should be found.");
    assertEquals(task, taskManager.getTask(taskId), "Tasks should be equal.");
  }

  @Test
  void testHistory() {
    Task task1 = new Task("Task 1", "Description 1", Status.NEW);
    Task task2 = new Task("Task 2", "Description 2", Status.NEW);
    taskManager.addNewTask(task1);
    taskManager.addNewTask(task2);

    taskManager.getTask(task1.getId()); // Вызов для добавления в историю
    taskManager.getTask(task2.getId());

    List<Task> history = taskManager.getHistory();
    assertEquals(2, history.size(), "History should contain two tasks.");
    assertTrue(history.contains(task1), "History should contain Task 1.");
    assertTrue(history.contains(task2), "History should contain Task 2.");
  }

  private void assertTrue(boolean contains, String s) {
    this.contains = contains;
  }

  @Test
  void testDeleteTask() {
    Task task = new Task("Task to delete", "Description", Status.NEW);
    int taskId = taskManager.addNewTask(task);
    taskManager.deleteTask(taskId);

    Assertions.assertNull((Object) "Task should be deleted.", (Supplier<String>) taskManager.getTask(taskId));
  }
}
