package com.emc.storageos.fabric.models.disks;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.emc.storageos.fabric.models.utils.CommonInfo;

/**
 * REST API model for info about a single disk at the disk level
 *
 */
@XmlRootElement(name = "disk")
public class DiskInfo extends CommonInfo implements Serializable {
    private String swid;
    private String hwid;

    @XmlElement(name = "disk_swid")
    public String getSwId(){
        return swid;
    }
    
    public void setSwId(String id){
        this.swid = id;
    }
    
    @XmlElement(name = "disk_hwid")
    public String getHwId(){
        return hwid;
    }
    
    public void setHwId(String id){
        this.hwid = id;
    }
    
}
