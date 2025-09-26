package com.mogou.service;

import com.mogou.repository.TaskRepository;
import com.mogou.model.Task;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class TaskService {

    private final TaskRepository repo;

    public TaskService(TaskRepository repo) {
        this.repo = repo;
    }

    public Task create(Task t) {
        return repo.save(t);
    }

    public List<Task> findAll() {
        return repo.findAll();
    }

    public List<Task> findByStatus(Task.Status status) {
        return repo.findByStatus(status);
    }

    public Optional<Task> findById(Long id) {
        return repo.findById(id);
    }

    public Task update(Long id, Task updated) {
        return repo.findById(id).map(existing -> {
            existing.setTitle(updated.getTitle());
            existing.setDescription(updated.getDescription());
            existing.setStatus(updated.getStatus());
            return repo.save(existing);
        }).orElseThrow(() -> new IllegalArgumentException("Task not found: " + id));
    }

    public void delete(Long id) {
        repo.deleteById(id);
    }
}