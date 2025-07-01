package org.example;

import java.util.ArrayList;
import java.util.List;

public class Epic extends Task {
  private final List<Integer> subtaskIds = new ArrayList<>();

  public Epic(String title, String description) {
    super(title, description, Status.NEW);
  }

  public void addSubtask(Integer subtaskId) {
    subtaskIds.add(subtaskId);
  }

  public List<Integer> getSubtaskIds() {
    return subtaskIds;
  }

  public void removeSubtask(Integer subtaskId) {
    subtaskIds.remove(subtaskId);
  }

  @Override
  public String toString() {
    return "Epic{" +
        "subtaskIds=" + subtaskIds +
        "} " + super.toString();
  }
}
