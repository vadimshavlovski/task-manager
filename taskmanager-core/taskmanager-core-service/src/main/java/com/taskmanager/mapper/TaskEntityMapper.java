package com.taskmanager.mapper;

import com.taskmanager.domain.Task;
import com.taskmanager.entity.TaskEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface TaskEntityMapper {

    @Mapping(expression = "java(java.time.Instant.now())", target = "createdAt")
    TaskEntity toEntity(Task data);

    Task toData(TaskEntity entity);

    void patch(@MappingTarget final TaskEntity entity, Task data);

}
