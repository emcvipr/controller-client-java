package com.emc.storageos.fabric.models.disks;

import java.io.Serializable;
import java.net.URI;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.emc.storageos.fabric.models.utils.CommonInfo;
/**
 * Disk info for FabricDiskList
 *
 */
public class FabricDiskInfo extends CommonInfo implements Serializable {
    /**
     * Disk type
     */
    private String disktype;
    /**
     * Node
     */
    private URI node;
    
    @XmlElement(name = "disktype")
    public String getDiskType(){
        return disktype;
    }
    
    public void setDiskType(String disktype){
        this.disktype = disktype;
    }
    
    @XmlElement(name = "node_id")
    public URI getNode(){
        return node;
    }
    
    public void setNode(URI node){
        this.node = node;
    }

}
