package com.taskmanager.service;

import com.taskmanager.domain.Task;
import com.taskmanager.entity.TaskEntity;
import com.taskmanager.mapper.TaskEntityMapper;
import com.taskmanager.repository.TaskRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TaskServiceImpl implements TaskService {

    private final TaskRepository repository;
    private final TaskEntityMapper mapper;

    @Override
    public List<Task> getAll() {
        return repository.findAll()
            .stream().map(mapper::toData).collect(Collectors.toList());
    }

    @Override
    public Task getById(@NotNull Long id) {
        return mapper.toData(repository.getOne(id));
    }

    @Override
    public Task create(@Valid Task task) {
        TaskEntity entity = mapper.toEntity(task);
        return mapper.toData(repository.save(entity));
    }

    //add TaskNotFoundException
    @Override
    public Task update(@NotNull Long id, @Valid Task task) {
        TaskEntity entity = repository.getOne(id);
        mapper.patch(entity, task);
        return mapper.toData(repository.save(entity));
    }

    @Override
    public Task delete(@NotNull Long id) {
        TaskEntity entity = repository.getOne(id);
        repository.delete(entity);
        return mapper.toData(entity);
    }
}
