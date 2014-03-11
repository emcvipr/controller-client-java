package com.emc.vipr.model.object.ingestion;


import com.emc.storageos.model.DataObjectRestRep;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Information about the ingestion task
 */
@XmlRootElement(name = "object_ingestion")
@XmlAccessorType(XmlAccessType.PROPERTY)
public class ObjectIngestionRestRep extends DataObjectRestRep {

    private String taskState;
    private String taskError;
    private String failedFile;

    public ObjectIngestionRestRep() {

    }

    /**
     * State of the ingestion task
     * @valid None
     */
    @XmlElement(name="task_state")
    public String getTaskState() {
        return taskState;
    }

    public void setTaskState(String taskState) {
        this.taskState = taskState;
    }

    /**
     * Error associated with the ingestion task, if any
     * @valid None
     */
    @XmlElement(name="task_error")
    public String getTaskError() {
        return taskError;
    }

    public void setTaskError(String taskError) {
        this.taskError = taskError;
    }

    /**
     * Name of the first file, within the file share, from which an object
     * could not be created
     * @valid None
     */
    @XmlElement(name="failed_file")
    public String getFailedFile() {
        return failedFile;
    }

    public void setFailedFile(String failedFile) {
        this.failedFile = failedFile;
    }
}
