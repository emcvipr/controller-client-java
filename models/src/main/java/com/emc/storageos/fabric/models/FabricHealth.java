package com.emc.storageos.fabric.models;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.emc.storageos.fabric.models.utils.HealthEnum;
import com.emc.storageos.fabric.models.utils.ModeEnum;
import com.emc.storageos.fabric.models.utils.NodeIdList;
/**
 * REST API model for overall Fabric health info
 *
 */
@XmlRootElement(name = "fabric_health")
public class FabricHealth {
    /**
     * Current overall health status of the fabric
     */
    private HealthEnum health;
    /**
     * Software version
     */
    private String version;
    /**
     * Node count
     */
    private int count;
    /**
     * List of nodes in BAD state
     */
    private NodeIdList badNodes;
    /**
     * List of nodes in suspect state
     */
    private NodeIdList suspectNodes;
    /**
     * List of nodes in degraded state
     */
    private NodeIdList degradedNodes;
    /**
     * List of nodes in maintenance mode
     */
    private NodeIdList maintenanceModeNodes; 
    
    @XmlElement(name = "status")
    public HealthEnum getHealth(){
        return health;
    }
    
    public void setHealth(HealthEnum health){
        this.health = health;
    }
    
    @XmlElement(name = "sw_version")
    public String getVersion() {
        return version;
    }
    
    public void setVersion(String version) {
        this.version = version;
    }
    
    @XmlElement(name = "node_count")
    public int getNodeCount() {
        return count;
    }
    
    public void setNodeCount(int count) {
        this.count = count;
    }
    
    @XmlElement(name = "bad_nodes")
    public NodeIdList getBadNodes() {
        return badNodes;
    }
    
    public void setBadNodes(NodeIdList nodes) {
        badNodes = nodes;
    }
    
    @XmlElement(name = "suspect_nodes")
    public NodeIdList getSuspectNodes() {
        return suspectNodes;
    }
    
    public void setSuspectNodes(NodeIdList nodes) {
        suspectNodes = nodes;
    }
    
    @XmlElement(name = "degraded_nodes")
    public NodeIdList getDegradedNodes() {
        return degradedNodes;
    }
    
    public void setDegradedNodes(NodeIdList nodes) {
        degradedNodes = nodes;
    }
    
    @XmlElement(name = "maintenance_mode_nodes")
    public NodeIdList getMaintenanceModeNodes() {
        return maintenanceModeNodes;
    }
    
    public void setMaintenanceModeNodes(NodeIdList nodes) {
        maintenanceModeNodes = nodes;
    }
    
    
    
    
    


}
