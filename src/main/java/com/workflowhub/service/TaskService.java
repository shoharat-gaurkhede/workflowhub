package com.workflowhub.service;

import com.workflowhub.controller.TaskController;
import com.workflowhub.model.Task;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Service
public class TaskService {

    private final List<Task> tasks = new ArrayList<>();
    private Long nextId = 1L;

    public Task createTask(@RequestBody Task task) {
        task.setId(nextId);
        nextId++;
        tasks.add(task);
        return task;
    }

    public List<Task> getAllTasks() {
        return tasks;
    }

    public Task getTaskById(Long id) {
        for (Task t: tasks) {
            if (t.getId().equals(id)) {
                return t;
            }
        }
        throw new RuntimeException("Task not found");
    }

    public void deleteTask(Long id) {
        Iterator<Task> iterator = tasks.iterator();
        while (iterator.hasNext()) {
            Task task = iterator.next();
            if(task.getId().equals(id)) {
                iterator.remove();
                return;
            }
        }
        throw new RuntimeException("Invalid Task");
    }
}
