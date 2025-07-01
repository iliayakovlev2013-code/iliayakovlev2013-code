package org.example;

import java.util.List;

public interface HistoryManager {
  void add(Task task);

  default List<Task> getHistory() {
    return null;
  }
}
