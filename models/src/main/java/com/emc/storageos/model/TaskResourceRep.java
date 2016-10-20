/*
 * Copyright (c) 2008-2011 EMC Corporation
 * All Rights Reserved
 */

package com.emc.storageos.model;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import org.codehaus.jackson.annotate.JsonIgnore;

import com.emc.storageos.model.adapters.CalendarAdapter;
import com.emc.storageos.model.errorhandling.ServiceErrorRestRep;

@XmlAccessorType(XmlAccessType.PROPERTY)
@XmlRootElement(name = "task")
public class TaskResourceRep extends DataObjectRestRep {
    private ServiceErrorRestRep serviceError;
    private String opId;
    private RestLinkRep selfLink;
    private NamedRelatedResourceRep resource;
    private RelatedResourceRep tenant;
    private List<NamedRelatedResourceRep> associatedResources;
    private String message;
    private String state;
    private String description;
    private Calendar startTime;
    private Calendar endTime;
    private Calendar lastUpdatedTime;
    private Integer progress;
    private Calendar queuedStartTime;
    private String queueName;
    private String allowedOperations;

    private RelatedResourceRep workflow;

    public TaskResourceRep() {
    }

    public TaskResourceRep(ServiceErrorRestRep serviceError, String opId,
            RestLinkRep selfLink, NamedRelatedResourceRep resource,
            List<NamedRelatedResourceRep> associatedResources, String message,
            String state, String allowedOperations, String description, Calendar startTime,
            Calendar endTime) {
        super();
        this.serviceError = serviceError;
        this.opId = opId;
        this.selfLink = selfLink;
        this.resource = resource;
        this.associatedResources = associatedResources;
        this.message = message;
        this.state = state;
        this.allowedOperations = allowedOperations;
        this.description = description;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    /**
     * The task operation id
     * 
     */
    @XmlElement(name = "op_id")
    public String getOpId() {
        return opId;
    }

    public void setOpId(String opId) {
        this.opId = opId;
    }

    /**
     * The resource link to the task
     * 
     * @deprecated Use {@link #getLink()}
     */
    @JsonIgnore
    @Deprecated
    public RestLinkRep getRestLink() {
        return selfLink;
    }

    /**
     * Resource link representative with name and id attached
     * 
     */
    @XmlElement(name = "resource")
    public NamedRelatedResourceRep getResource() {
        return resource;
    }

    public void setResource(NamedRelatedResourceRep resource) {
        this.resource = resource;
    }

    /**
     * Link to tenant who owns this task. No tenant means the task is a SYSTEM level task (i.e. discovery etc)
     */
    @XmlElement(name = "tenant")
    public RelatedResourceRep getTenant() {
        return tenant;
    }

    public void setTenant(RelatedResourceRep tenant) {
        this.tenant = tenant;
    }

    /**
     * A list of links for associated resources
     * 
     */
    @XmlElementWrapper(name = "associated_resources")
    @XmlElement(name = "associated_resource")
    public List<NamedRelatedResourceRep> getAssociatedResources() {
        if (associatedResources == null) {
            associatedResources = new ArrayList<NamedRelatedResourceRep>();
        }
        return associatedResources;
    }

    public void setAssociatedResources(List<NamedRelatedResourceRep> associatedResources) {
        this.associatedResources = associatedResources;
    }

    /**
     * The state of the task
     * Valid values:
     *      queued = task is queued
     *      pending = task is pending
     *      ready = task succeed
     *      error = task fails
     *      suspended_error = task is suspended due to an error
     *      suspended_no_error = task is suspended due to config/request
     */
    @XmlElement(name = "state")
    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    /**
     * The allowed operations of the task
     */
    @XmlElement(name = "allowed_operations")
    public String getAllowedOperations() {
        return allowedOperations;
    }

    public void setAllowedOperations(String allowedOperations) {
        this.allowedOperations = allowedOperations;
    }

    /**
     * The task detail message
     * 
     */
    @XmlElement(name = "message")
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    /**
     * The description of the task
     * 
     */
    @XmlElement(name = "description")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * The service error code when a problem was encountered while processing a request
     * 
     */
    @XmlElement(name = "service_error")
    public ServiceErrorRestRep getServiceError() {
        return serviceError;
    }

    public void setServiceError(ServiceErrorRestRep serviceError) {
        this.serviceError = serviceError;
    }

    /**
     * The date and time of when the task was started
     * 
     */
    @XmlElement(name = "start_time")
    @XmlJavaTypeAdapter(CalendarAdapter.class)
    public Calendar getStartTime() {
        return startTime;
    }

    public void setStartTime(Calendar start_time) {
        startTime = start_time;
    }

    /**
     * The date and time of when the task ended
     * 
     */
    @XmlElement(name = "end_time")
    @XmlJavaTypeAdapter(CalendarAdapter.class)
    public Calendar getEndTime() {
        return endTime;
    }

    public void setEndTime(Calendar endTime) {
        this.endTime = endTime;
    }

    @XmlElement(name = "progress")
    public Integer getProgress() {
        return progress;
    }

    public void setProgress(Integer progress) {
        this.progress = progress;
    }

    @XmlElement(name = "workflow")
    public RelatedResourceRep getWorkflow() {
        return workflow;
    }

    public void setWorkflow(RelatedResourceRep workflow) {
        this.workflow = workflow;
    }

    @XmlElement(name = "queuedStartTime")
    public Calendar getQueuedStartTime() {
        return queuedStartTime;
    }

    public void setQueuedStartTime(Calendar queuedStartTime) {
        this.queuedStartTime = queuedStartTime;
    }

    @XmlElement(name = "queueName")
    public String getQueueName() {
        return queueName;
    }

    public void setQueueName(String queueName) {
        this.queueName = queueName;
    }

}
