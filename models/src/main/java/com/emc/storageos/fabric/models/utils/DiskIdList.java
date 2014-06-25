package com.emc.storageos.fabric.models.utils;

import java.io.Serializable;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
/**
 * Generic model class for creating a list of disk ids
 *
 */
@XmlRootElement(name = "disks")
public class DiskIdList implements Serializable {
    private List<URI> disks;
    
    public DiskIdList() {
        if (disks == null) {
            disks = new ArrayList<URI>();
        }
    }
    
    public DiskIdList(List<URI> disks) {
        this.disks = disks;
    }

    /**
     * List of disks by id
     * @valid none
     */
    @XmlElement(name = "id")
    public List<URI> getDiskList() {
        if (disks == null) {
            disks = new ArrayList<URI>();
        }
        return disks;
    }

    public void setDiskList(List<URI> disks) {
        this.disks = disks;
    }
    
    /**
     * Utility method to add node ids to the list individually
     * @param node
     */
    public void add(URI disk){
        if (disks == null) {
            disks = new ArrayList<URI>();
        }
        disks.add(disk);
    }
    
}
