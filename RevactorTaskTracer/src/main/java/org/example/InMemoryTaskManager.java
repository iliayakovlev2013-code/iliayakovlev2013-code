package org.example;

import java.util.*;

public class InMemoryTaskManager implements TaskManager {
  private final Map<Integer, Task> tasks = new HashMap<>();
  private int nextId = 1;
  private final HistoryManager historyManager = Managers.getDefaultHistory();

  @Override
  public int addNewTask(Task task) {
    task.setId(nextId);
    tasks.put(nextId, task);
    nextId++;
    return task.getId();
  }

  @Override
  public Task getTask(int id) {
    Task task = tasks.get(id);
    if (task != null) {
      historyManager.add(task);
    }
    return task;
  }

  @Override
  public void deleteTask(int id) {
    tasks.remove(id);
  }

  @Override
  public List<Task> getTasks() {
    return new ArrayList<>(tasks.values());
  }

  @Override
  public List<Task> getHistory() {
    return historyManager.getHistory();
  }
}
