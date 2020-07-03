package com.fintech.soapserivce.dto;

import com.fintech.soapserivce.domain.Person;
import com.fintech.soapserivce.domain.Task;
import lombok.Data;
import org.springframework.beans.BeanUtils;

@Data
public class TaskDTO {
    private Long id;
    private int priority;
    private String priorityName;
    private Long personId;
    private String personName;
    private String classTable;

    public TaskDTO(Task task) {
        BeanUtils.copyProperties(task, this);
        Person person = task.getPerson();
        this.personId = person.getId();
        this.personName = person.getName();
        Task.PriorityLevels levels = Task.PriorityLevels.getPriorityByCode(task.getPriority());
        this.priorityName = levels.getName();
        this.classTable = levels.getClassBtrap();
    }
}
