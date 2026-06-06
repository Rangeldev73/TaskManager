package com.rangel.controller;
import com.rangel.model.*;
import com.rangel.service.*;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/tasks")
public class TaskController {
    private TaskService service = new TaskService();

    @PostMapping
    public Task create(String title, String description){
        return service.createTask(title,description);
    }

    @GetMapping
    public List<Task> getAll(){
        return service.getAllTasks();
    }

    @GetMapping("/{id}")
    public Task getById(Long id){
        return service.getTaskById(id);
    }

    @DeleteMapping("/{id}")
    public boolean delete(Long id){
        return service.deleteTask(id);
    }
}
