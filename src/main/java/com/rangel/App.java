package com.rangel;
import com.rangel.controller.TaskController;
import com.rangel.model.Task;
import java.util.List;
public class App {
    public static void main(String[] args) {
        TaskController controller = new TaskController();

        controller.create("Study Java", "Practice OOP and layered architecture");
        controller.create("Push to GitHub", "Upload the taskmanager to the repository");
        controller.create("Learn Spring Boot", "Next phase of the mentorship");

        System.out.println("=== ALL TASKS ===");
        List<Task> tasks = controller.getAll();
        for (Task task : tasks) {
            System.out.println("[" + task.getId() + "] " + task.getTitle() + " | " + task.getStatus());
        }

        System.out.println("\n=== SEARCH BY ID 2 ===");
        Task found = controller.getById(2L);
        System.out.println("Found: " + found.getTitle());

        System.out.println("\n=== DELETING ID 1 ===");
        boolean deleted = controller.delete(1L);
        System.out.println("Deleted: " + deleted);

        System.out.println("\n=== TASKS AFTER DELETE ===");
        for (Task task : controller.getAll()) {
            System.out.println("[" + task.getId() + "] " + task.getTitle());
        }
    }
}
