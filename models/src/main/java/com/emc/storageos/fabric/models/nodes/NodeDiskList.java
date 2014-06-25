package com.emc.storageos.fabric.models.nodes;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
/**
 * List of disks for a single node
 *
 */
@XmlRootElement(name = "disks")
public class NodeDiskList implements Serializable {
private List<NodeDisk> disks;
    
    public NodeDiskList() {}
    
    public NodeDiskList(List<NodeDisk> disks) {
        this.disks = disks;
    }

    /**
     * List of disks from node level
     * @valid none
     */
    @XmlElement(name = "disk")
    public List<NodeDisk> getList() {
        if (disks == null) {
            disks = new ArrayList<NodeDisk>();
        }
        return disks;
    }

    public void setList(List<NodeDisk> disks) {
        this.disks = disks;
    }
}
