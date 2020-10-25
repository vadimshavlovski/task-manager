package com.taskmanager.ui.controller;

import com.taskmanager.domain.Task;
import com.taskmanager.service.TaskService;
import com.taskmanager.ui.dto.TaskDto;
import com.taskmanager.ui.mapper.TaskDtoMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;


@RestController
@RequestMapping("/tasks")
@RequiredArgsConstructor
@Slf4j
public class TaskRestController {

    private final TaskService taskService;
    private final TaskDtoMapper taskDtoMapper;

    @GetMapping
    public List<TaskDto> getAll() {
        return taskService.getAll()
            .stream().map(taskDtoMapper::toDto)
            .collect(Collectors.toList());
    }

    @GetMapping(value = "/{id}")
    public TaskDto getById(@PathVariable("id") Long id) {
        return taskDtoMapper.toDto(taskService.getById(id));
    }

    @PostMapping
    public TaskDto createTask(@RequestBody TaskDto dto) {
        Task task = taskDtoMapper.toData(dto);
        return taskDtoMapper.toDto(taskService.create(task));
    }

    @PatchMapping(value = "/{id}")
    public TaskDto updateTask(@PathVariable("id") Long id, @Valid @RequestBody TaskDto dto) {
        Task task = taskDtoMapper.toData(dto);
        return taskDtoMapper.toDto(taskService.update(id, task));
    }

    @DeleteMapping(value = "/{id}")
    public TaskDto deleteById(@PathVariable("id") Long id) {
        return taskDtoMapper.toDto(taskService.delete(id));
    }
}
