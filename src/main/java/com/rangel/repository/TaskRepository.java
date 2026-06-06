package com.rangel.repository;
import com.rangel.model.*;
import java.util.ArrayList;
import java.util.List;
public class TaskRepository {
    private List<Task> tasks = new ArrayList<>();
    private Long nextId = 1L;

    public Task save(Task task){
        task.setId(nextId++);
        tasks.add(task);
        return task;
    }

    public List<Task> findAll(){
        return new ArrayList<>(tasks);
    }

    public Task findById(Long id){
        for(Task task : tasks){
            if(task.getId().equals(id)){
                return task;
            }
        }
        return null;
    }

    public boolean deleteById(Long id){
        return tasks.removeIf(task -> task.getId().equals(id));
    }
}
