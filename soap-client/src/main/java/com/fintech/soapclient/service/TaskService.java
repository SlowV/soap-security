package com.fintech.soapclient.service;

import com.fintech.soapclient.bindings.GetAllTasksRequest;
import com.fintech.soapclient.bindings.GetAllTasksResponse;
import com.fintech.soapclient.bindings.TaskInfo;
import com.fintech.soapclient.config.SoapConnector;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {
    @Autowired
    SoapConnector soapConnector;

    public List<TaskInfo> getAllTasks() {
        return ((GetAllTasksResponse) soapConnector.callWebService(new GetAllTasksRequest())).getTaskInfo();
    }
}
