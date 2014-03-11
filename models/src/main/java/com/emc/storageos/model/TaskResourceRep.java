/**
 *  Copyright (c) 2008-2011 EMC Corporation
 * All Rights Reserved
 *
 * This software contains the intellectual property of EMC Corporation
 * or is licensed to EMC Corporation from third parties.  Use of this
 * software and the intellectual property contained therein is expressly
 * limited to the terms and conditions of the License Agreement under which
 * it is provided by or on behalf of EMC.
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

import com.emc.storageos.model.errorhandling.ServiceErrorRestRep;
import com.emc.storageos.model.adapters.CalendarAdapter;

@XmlAccessorType(XmlAccessType.PROPERTY)
@XmlRootElement(name = "task")
public class TaskResourceRep {
    private ServiceErrorRestRep serviceError;
    private String opId;
    private RestLinkRep selfLink;
    private NamedRelatedResourceRep resource;
    private List<NamedRelatedResourceRep> associatedResources;
    private String message;
    private String state;
    private String description;
    private Calendar startTime;
    private Calendar endTime;

    public TaskResourceRep() {}
    
    public TaskResourceRep(ServiceErrorRestRep serviceError, String opId,
            RestLinkRep selfLink, NamedRelatedResourceRep resource,
            List<NamedRelatedResourceRep> associatedResources, String message,
            String state, String description, Calendar startTime,
            Calendar endTime) {
        super();
        this.serviceError = serviceError;
        this.opId = opId;
        this.selfLink = selfLink;
        this.resource = resource;
        this.associatedResources = associatedResources;
        this.message = message;
        this.state = state;
        this.description = description;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    /** 
     * The task operation id
     * @valid none
     */
    @XmlElement(name = "op_id")
    public String getOpId() { 
        return opId; 
    }
    
    public void  setOpId(String opId) { 
        this.opId = opId; 
    }

    /** 
     * The resource link to the task
     * @valid none
     */
    @XmlElement(name = "link")
    public RestLinkRep getRestLink() {
        return selfLink;
    }
    
    public void setRestLink(RestLinkRep selfLink) { 
        this.selfLink = selfLink; 
    }

    /** 
     * Resource link representative with name and id attached
     * @valid none
     */
    @XmlElement(name = "resource")
    public NamedRelatedResourceRep  getResource() {
        return resource; 
    }
    
    public void setResource(NamedRelatedResourceRep resource) { 
        this.resource = resource;
    }

    /** 
     * A list of links for associated resources
     * @valid none
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
     * @valid pending = task is pending 
     * @valid ready = task succeed
     * @valid error = task fails
     */
    @XmlElement(name = "state")
    public String getState() { 
        return state; 
    }
    
    public void setState(String state) { 
        this.state = state;
    }

    /** 
     * The task detail message 
     * @valid none
     */
    @XmlElement (name = "message")
    public String getMessage() { 
        return message; 
    }
    
    public void setMessage(String message) { 
        this.message = message;
    }

    /** 
     * The description of the task
     * @valid none
     */
    @XmlElement (name = "description")
    public String getDescription() {
        return description;
    }
    
    public void setDescription(String description) {
        this.description = description;
    }

    /** 
     * The service error code when a problem was encountered while processing a request
     * @valid none
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
     * @valid none
     */
    @XmlElement (name = "start_time")
    @XmlJavaTypeAdapter(CalendarAdapter.class)
    public Calendar getStartTime() {
        return startTime;
    }
    
    public void setStartTime(Calendar start_time) {
        startTime = start_time;
    }

    /** 
     * The date and time of when the task ended
     * @valid none
     */
    @XmlElement (name = "end_time")
    @XmlJavaTypeAdapter(CalendarAdapter.class)
    public Calendar getEndTime() {
        return endTime;
    }
    
    public void setEndTime(Calendar endTime) {
        this.endTime = endTime;
    }
}
