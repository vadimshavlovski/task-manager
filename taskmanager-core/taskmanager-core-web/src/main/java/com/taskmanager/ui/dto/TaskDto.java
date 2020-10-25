package com.taskmanager.ui.dto;

import com.taskmanager.domain.Priority;
import com.taskmanager.domain.Status;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;

@Getter
@Setter
public class TaskDto {

    private String id;
    @NotEmpty
    private String name;
    private String description;
    @NotEmpty
    private Priority priority;
    @NotEmpty
    private Status status;
}
