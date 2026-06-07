package com.rangel.controller;
import com.rangel.model.*;
import com.rangel.service.*;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/tasks")
public class TaskController {
    private final TaskService service;

    public TaskController(TaskService service) {
        this.service = service;
    }

    @PostMapping
    public Task create(@RequestParam String title,
                       @RequestParam String description) {
        return service.createTask(title, description);
    }

    @GetMapping
    public List<Task> getAll(){
        return service.getAllTasks();
    }

    @GetMapping("/{id}")
    public Task getById(@PathVariable Long id) {
        return service.getTaskById(id);
    }

    @DeleteMapping("/{id}")
    public boolean delete(@PathVariable Long id) {
        return service.deleteTask(id);
    }
}
