package com.emc.storageos.fabric.models.utils;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlElement;
/**
 * REST API model for the status of a service
 *
 */
public class ServiceStatus implements Serializable {
    /**
     * service name 
     */
    private String name;
    /**
     * Service status
     */
    private ServiceStatusEnum status;
    
    @XmlElement(name = "name")
    public String getName(){
        return name;
    }
    
    public void setName(String name){
        this.name = name;
    }
    
    @XmlElement(name = "status")
    public ServiceStatusEnum getStatus(){
        return status;
    }
    
    public void setStatus(ServiceStatusEnum status){
        this.status = status;
    }
    
}
