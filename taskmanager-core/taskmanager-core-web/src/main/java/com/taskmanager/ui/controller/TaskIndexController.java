package com.taskmanager.ui.controller;

import com.taskmanager.service.TaskService;
import com.taskmanager.ui.dto.TaskDto;
import com.taskmanager.ui.mapper.TaskDtoMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/tasks")
@RequiredArgsConstructor
@Slf4j
public class TaskIndexController {

    private final TaskService taskService;
    private final TaskDtoMapper taskDtoMapper;

    @GetMapping("/all")
    public String getAll(Model model) {
        List<TaskDto> tasks = taskService.getAll()
            .stream().map(taskDtoMapper::toDto)
            .collect(Collectors.toList());
        model.addAttribute("tasks", tasks);
        return "tasks";
    }
}
