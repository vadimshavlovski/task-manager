package com.taskmanager.ui.mapper;

import com.taskmanager.domain.Task;
import com.taskmanager.ui.dto.TaskDto;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface TaskDtoMapper {

    TaskDto toDto(Task data);

    Task toData(TaskDto dto);
}
