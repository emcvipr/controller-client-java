package com.emc.storageos.fabric.models.services;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.emc.storageos.fabric.models.utils.CommonInfo;
import com.emc.storageos.fabric.models.utils.NodeIdList;
/**
 * REST API model for info about a service
 *
 */
@XmlRootElement(name = "service")
public class ServiceInfo extends CommonInfo implements Serializable {
    /**
     * Instance count of the service
     */
    private int count;
    /**
     * Service version number
     */
    private String version;
    /**
     * List of nodes with the service configured
     */
    private NodeIdList nodeList;
    
    @XmlElement(name = "instance_count")
    public int getCount(){
        return count;
    }
    
    public void setCount(int count){
        this.count = count;
    }
    
    @XmlElement(name = "version")
    public String getVersion(){
        return version;
    }
    
    public void setVersion(String version){
        this.version = version;
    }
 
}
