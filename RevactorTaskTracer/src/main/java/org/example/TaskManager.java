package org.example;

import java.util.List;

public interface TaskManager {
  int addNewTask(Task task);
  Task getTask(int id);
  void deleteTask(int id);
  List<Task> getTasks();
  List<Task> getHistory();
}
