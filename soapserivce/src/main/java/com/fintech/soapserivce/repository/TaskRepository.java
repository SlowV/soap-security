package com.fintech.soapserivce.repository;

import com.fintech.soapserivce.domain.Task;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TaskRepository extends JpaRepository<Task, Long> {
    List<Task> findAllByOrderByPriorityDesc();
}
