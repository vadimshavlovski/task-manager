package com.taskmanager.domain;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;


@Getter
@Setter
public class Task {
    private String id;
    @NotEmpty
    private String name;
    private String description;
    @NotEmpty
    private Priority priority;
    @NotEmpty
    private Status status;

}
