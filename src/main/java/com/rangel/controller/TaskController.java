package com.rangel.controller;
import com.rangel.model.*;
import com.rangel.service.*;

import java.util.List;

public class TaskController {
    private TaskService service = new TaskService();

    public Task create(String title, String description){
        return service.createTask(title,description);
    }

    public List<Task> getAll(){
        return service.getAllTasks();
    }

    public Task getById(Long id){
        return service.getTaskById(id);
    }

    public boolean delete(Long id){
        return service.deleteTask(id);
    }
}
