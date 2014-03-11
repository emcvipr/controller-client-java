package com.emc.vipr.model.catalog;

import javax.xml.bind.annotation.XmlType;
import java.util.Date;

@XmlType
public class ExecutionLogInfo {
    private Date date;              // Date for this log message
    private String level;           // Level for this log message
    private String message;         // Log message
    private String stackTrace;      // Stacktrace for error log messages
    private String phase;           // Execution phase for this message

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getPhase() {
        return phase;
    }

    public void setPhase(String phase) {
        this.phase = phase;
    }

    public String getStackTrace() {
        return stackTrace;
    }

    public void setStackTrace(String stackTrace) {
        this.stackTrace = stackTrace;
    }
}
