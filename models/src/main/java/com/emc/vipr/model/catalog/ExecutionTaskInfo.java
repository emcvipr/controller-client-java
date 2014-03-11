package com.emc.vipr.model.catalog;

import javax.xml.bind.annotation.XmlType;

@XmlType
public class ExecutionTaskInfo extends ExecutionLogInfo {
    private String detail;                  // Details for this task
    private Long elapsed;                   // Length of time the task ran for

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public Long getElapsed() {
        return elapsed;
    }

    public void setElapsed(Long elapsed) {
        this.elapsed = elapsed;
    }
}
