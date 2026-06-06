package com.rangel.service;
import com.rangel.repository.*;
import com.rangel.model.*;

import java.util.ArrayList;
import java.util.List;

public class TaskService {
    private TaskRepository repository = new TaskRepository();

    public Task createTask(String title, String description) {
        Task task = new Task(title, description);
        return repository.save(task);
    }

    public List<Task> getAllTasks() {
        return repository.findAll();
    }

    public Task getTaskById(Long id) {
        return repository.findById(id);
    }

    public boolean deleteTask(Long id) {
        return repository.deleteById(id);
    }
}
