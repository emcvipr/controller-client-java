package com.emc.vipr.model.catalog;

import javax.xml.bind.annotation.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@XmlRootElement
@XmlAccessorType(XmlAccessType.PROPERTY)
public class ExecutionInfo {
    // Info on the execution state
    private Date startDate;                         // Date this order started
    private Date endDate;                           // Date this order completed
    private String executionStatus;                 // Status of this execution
    private String currentTask;                     // The current task that is running
    private List<String> affectedResources;         // Resources that were affected (created/updated/deleted) by this service
    private List<ExecutionLogInfo> executionLogs;   // Log information for this order execution
    private List<ExecutionTaskInfo> executionTasks; // Task information for this order execution

    @XmlElementWrapper(name = "affectedResources")
    @XmlElement(name="resource")
    public List<String> getAffectedResources() {
        if (affectedResources == null) {
            affectedResources = new ArrayList<String>();
        }
        return affectedResources;
    }

    public String getCurrentTask() {
        return currentTask;
    }

    public void setCurrentTask(String currentTask) {
        this.currentTask = currentTask;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    @XmlElementWrapper(name = "executionLogs")
    @XmlElement(name="log")
    public List<ExecutionLogInfo> getExecutionLogs() {
        if (executionLogs == null) {
            executionLogs = new ArrayList<ExecutionLogInfo>();
        }
        return executionLogs;
    }

    public String getExecutionStatus() {
        return executionStatus;
    }

    public void setExecutionStatus(String executionStatus) {
        this.executionStatus = executionStatus;
    }

    @XmlElementWrapper(name = "executionTasks")
    @XmlElement(name="task")
    public List<ExecutionTaskInfo> getExecutionTasks() {
        if (executionTasks == null) {
            executionTasks = new ArrayList<ExecutionTaskInfo>();
        }
        return executionTasks;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }
}
