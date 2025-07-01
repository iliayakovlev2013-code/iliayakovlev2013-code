package org.example;

public class Main {
  public static void main(String[] args) {
    TaskManager manager = Managers.getDefault();

    // Создаем задачи
    Task task1 = new Task("Задача 1", "Описание задачи 1", Status.NEW);
    Task task2 = new Task("Задача 2", "Описание задачи 2", Status.NEW);
    manager.addNewTask(task1);
    manager.addNewTask(task2);

    // Получаем и отображаем задачи
    System.out.println("Все задачи:");
    for (Task task : manager.getTasks()) {
      System.out.println(task);
    }

    // Получаем историю
    System.out.println("История просмотров:");
    for (Task task : manager.getHistory()) {
      System.out.println(task);
    }
  }
}
