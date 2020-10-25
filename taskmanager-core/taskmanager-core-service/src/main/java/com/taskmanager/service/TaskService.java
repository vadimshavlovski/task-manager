package com.taskmanager.service;

import com.taskmanager.domain.Task;

import java.util.List;

public interface TaskService {

    List<Task> getAll();

    Task getById(Long id);

    Task create(Task task);

    Task update(Long id, Task task);

    Task delete(Long id);
}
