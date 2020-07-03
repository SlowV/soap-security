package com.fintech.soapserivce.service;

import com.fintech.soapserivce.domain.Task;
import com.fintech.soapserivce.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {

    @Autowired
    TaskRepository taskRepository;

    public List<Task> getAllTasks() {
        return taskRepository.findAllByOrderByPriorityDesc();
    }
}
