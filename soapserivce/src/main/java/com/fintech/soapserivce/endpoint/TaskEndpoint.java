package com.fintech.soapserivce.endpoint;

import com.fintech.soapserivce.domain.Task;
import com.fintech.soapserivce.dto.TaskDTO;
import com.fintech.soapserivce.service.TaskService;
import com.fintech.soapservice.gs_ws.GetAllTasksResponse;
import com.fintech.soapservice.gs_ws.TaskInfo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import java.util.ArrayList;
import java.util.List;

@Endpoint
public class TaskEndpoint {
    private static final String NAMESPACE_URI = "http://www.fintech.com/task-ws";
    @Autowired
    private TaskService taskService;

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getAllTasksRequest")
    @ResponsePayload
    public GetAllTasksResponse getAllTasks() {
        GetAllTasksResponse response = new GetAllTasksResponse();
        List<TaskInfo> taskInfoList = new ArrayList<>();
        List<Task> taskList = taskService.getAllTasks();
        for (Task task : taskList) {
            TaskInfo taskInfo = new TaskInfo();
            BeanUtils.copyProperties(new TaskDTO(task), taskInfo);
            taskInfoList.add(taskInfo);
        }
        response.getTaskInfo().addAll(taskInfoList);
        return response;
    }
}
