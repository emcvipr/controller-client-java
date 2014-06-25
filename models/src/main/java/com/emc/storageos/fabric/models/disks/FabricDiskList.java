package com.emc.storageos.fabric.models.disks;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
/**
 * REST API model class for overall Fabric disk list
 *
 */
@XmlRootElement(name = "disks")
public class FabricDiskList implements Serializable {
private List<FabricDiskInfo> disks;
    
    public FabricDiskList() {
        disks = new ArrayList<FabricDiskInfo>();
    }
    
    public FabricDiskList(List<FabricDiskInfo> disks) {
        this.disks = disks;
    }

    /**
     * List of disks from fabric-level
     * @valid none
     */
    @XmlElement(name = "disk")
    public List<FabricDiskInfo> getList() {
        if (disks == null) {
            disks = new ArrayList<FabricDiskInfo>();
        }
        return disks;
    }

    public void setList(List<FabricDiskInfo> disks) {
        this.disks = disks;
    }
    
    public void add(FabricDiskInfo disk){
        if (disks == null) {
            disks = new ArrayList<FabricDiskInfo>();
        }
        disks.add(disk);
    }
    
    public int size(){
        if(disks == null){
            return 0;
        }
        return disks.size();
    }
    
    public String toString(){
        String out = new String();
        for(FabricDiskInfo d : disks){
            out += d.getId().toString();
            out += d.getNode().toString();
        }
        return out;
    }
}
