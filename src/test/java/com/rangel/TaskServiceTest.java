package com.rangel;

import com.rangel.model.Task;
import com.rangel.model.TaskStatus;
import com.rangel.repository.TaskRepository;
import com.rangel.service.TaskService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.Optional;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class TaskServiceTest {

    @Mock
    private TaskRepository repository;

    @InjectMocks
    private TaskService service;

    @Test
    void createTask_shouldReturnTaskWithPendingStatus() {
        Task task = new Task("Study Java", "Tests");
        when(repository.save(any(Task.class))).thenReturn(task);
        Task result = service.createTask("Study Java", "Tests");
        assertEquals(TaskStatus.PENDING, result.getStatus());
    }

    @Test
    void getTaskById_whenNotFound_shouldReturnNull() {
        when(repository.findById(99L)).thenReturn(Optional.empty());
        Task result = service.getTaskById(99L);
        assertNull(result);
    }
}
