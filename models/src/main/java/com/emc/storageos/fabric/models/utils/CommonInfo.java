package com.emc.storageos.fabric.models.utils;

import java.io.Serializable;
import java.net.URI;

import javax.xml.bind.annotation.XmlElement;
/**
 * Common class used or extended when any fabric element supplies id, link, and name
 *
 */
public class CommonInfo implements Serializable {
    /**
     * Element id
     */
    private URI id;
    /**
     * Link to self
     */
    private LinkResponse selfLink;
    /**
     * Element name
     */
    private String name;

    @XmlElement(name = "id")
    public URI getId(){
        return id;
    }
    
    public void setId(URI id){
        this.id = id;
    }
    
    @XmlElement(name = "link")
    public LinkResponse getSelfLink() {
        return selfLink;
    }

    public void setSelfLink(LinkResponse selfLink) {
        this.selfLink = selfLink;
    }
    
    @XmlElement(name = "name")
    public String getName(){
        return name;
    }
    
    public void setName(String name){
        this.name = name;
    }
    
}
