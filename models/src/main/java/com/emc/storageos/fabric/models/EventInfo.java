package com.emc.storageos.fabric.models;

import java.io.Serializable;
import java.net.URI;

import javax.xml.bind.annotation.XmlElement;
/**
 * REST API model for event info
 *
 */
public class EventInfo implements Serializable {
/*
 * <event>
               <description>Tenant roles updated</description>
               <event_id>urn:storageos:Event:53e1a748-da44-4459-8ce4-b00e7b51dcbd</event_id>
               <event_source>TenantManager</event_source>
               <event_type>TenantUpdated</event_type>
               <extensions></extensions>
               <operational_status_codes></operational_status_codes>
               <operational_status_descriptions></operational_status_descriptions>
               <record_type>Event</record_type>
               <resource_id>urn:storageos:TenantOrg:aca524d3-0310-41b8-99bb-685bf82bc09b:</resource_id>
               <service_type>tenant</service_type>
               <tenant_id>urn:storageos:TenantOrg:aca524d3-0310-41b8-99bb-685bf82bc09b:</tenant_id>
               <time_occurred>1379385174955</time_occurred>
               <user_id>ViPR-USER-TODO</user_id>
          </event>
 */
    //TODO determine if all attributes make sense for the fabric solution
    private String description;
    private URI id;
    private String eventSource;
    private String eventType;
    private String extensions;
    private String statusCodes;
    private String statusDesc;
    private String recordType;

    @XmlElement(name = "description")
    public String getDescription(){
        return description;
    }
    
    public void setDescription(String description){
        this.description = description;
    }
    
    @XmlElement(name = "event_id")
    public URI getId(){
        return id;
    }
    
    public void setId(URI id){
        this.id = id;
    }
    
    @XmlElement(name = "event_source")
    public String getEventSource(){
        return eventSource;
    }
    
    public void setSource(String eventSource){
        this.eventSource = eventSource;
    }
    
    @XmlElement(name = "event_type")
    public String getEventType(){
        return eventType;
    }
    
    public void setEventType(String eventType){
        this.eventType = eventType;
    }
}
