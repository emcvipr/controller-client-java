package com.emc.storageos.fabric.models.utils;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlElement;

public class ServiceName extends CommonInfo implements Serializable {
    private String disksetUUID;
    
    @XmlElement(name = "diskset_uuid")
    public String getDisksetUUID(){
        return disksetUUID;
    }
    
    public void setDisksetUUID(String disksetUUID){
        this.disksetUUID = disksetUUID;
    }
}
