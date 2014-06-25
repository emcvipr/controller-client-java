package com.emc.storageos.fabric.models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElements;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * List of Fabric statistics
 *
 */
@XmlRootElement(name = "fabric_stats")
public class StatsList implements Serializable {

    private List<NodeStats> stats;
        
    public StatsList() {
        stats = new ArrayList<NodeStats>();
    }
        
    public StatsList(List<NodeStats> nodes) {
        this.stats = stats;
    }

    /**
     * List of stats from fabric-level
     * @valid none
     */
    @XmlElement(name = "node_stats")
    public List<NodeStats> getList() {
        if (stats == null) {
            stats = new ArrayList<NodeStats>();
        }
        return stats;
    }

    public void setList(List<NodeStats> nodes) {
        this.stats = nodes;
    }
        
    public void add(NodeStats node){
        if (stats == null) {
            stats = new ArrayList<NodeStats>();
        }
        stats.add(node);
    }
    
    public int size(){
        if(stats == null){
            return 0;
        }
        return stats.size();
    }
}
