package com.taskmanager.repository;


import com.taskmanager.common.jpa.DomainEntityRepository;
import com.taskmanager.entity.TaskEntity;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskRepository extends DomainEntityRepository<TaskEntity, Long> {
}
