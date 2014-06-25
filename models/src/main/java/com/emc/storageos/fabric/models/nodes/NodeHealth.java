package com.emc.storageos.fabric.models.nodes;

import java.io.Serializable;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.emc.storageos.fabric.models.utils.DiskIdList;
import com.emc.storageos.fabric.models.utils.HealthEnum;
import com.emc.storageos.fabric.models.utils.LinkResponse;
import com.emc.storageos.fabric.models.utils.ModeEnum;
import com.emc.storageos.fabric.models.utils.ServiceStatus;
/**
 * REST API model for info about single node health
 *
 */
@XmlRootElement(name = "node_health")
public class NodeHealth implements Serializable {
    /**
     * Node id
     */
    private URI id;
    /**
     * Node self link
     */
    private LinkResponse selfLink;
    /**
     * health status
     */
    private HealthEnum nodeHealth;
    /**
     * mode (operational or maintenance)
     */
    private ModeEnum nodeMode;
    /**
     * List of the status of services on the node
     */
    private List<ServiceStatus> statuses;
    /**
     * Total disk count for the node
     */
    private int diskCount;
    /**
     * list of bad disks
     */
    private DiskIdList badDisks;
    /**
     * list of suspect disks
     */
    private DiskIdList suspectDisks;
    /**
     * list of maintenance disks
     */
    private DiskIdList maintenanceDisks;
    /**
     * list of staging disks
     */
    private DiskIdList stagingDisks;
    
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
    
    @XmlElement(name = "status")
    public HealthEnum getNodeHealth(){
        return nodeHealth;
    }
    
    public void setNodeHealth(HealthEnum nodeHealth){
        this.nodeHealth = nodeHealth;
    }
    
    @XmlElement(name = "mode")
    public ModeEnum getNodeMode(){
        return nodeMode;
    }
    
    public void setNodeMode(ModeEnum nodeMode){
        this.nodeMode = nodeMode;
    }
    
    @XmlElement(name = "service")
    public List<ServiceStatus> getStatuses(){
        if(statuses == null){
            statuses = new ArrayList<ServiceStatus>();
        }
        return statuses;
    }
    
    public void setStatuses(List<ServiceStatus> statuses){
        this.statuses = statuses;
    }
    
    /**
     * Add a ServiceStatus object to the existing list
     * @param status
     */
    public void addServiceStatus(ServiceStatus status){
        if(statuses == null){
            statuses = new ArrayList<ServiceStatus>();
        }
        statuses.add(status);
    }
    
    @XmlElement(name = "disk_count")
    public int getDiskCount() {
        return diskCount;
    }
    
    public void setDiskCount(int count) {
        diskCount = count;
    }
    
    @XmlElement(name = "bad_disks")
    public DiskIdList getBadDisks() {
        return badDisks;
    }
    
    public void setBadDisks(DiskIdList disks) {
        badDisks = disks;
    }
    
    @XmlElement(name = "suspect_disks")
    public DiskIdList getSuspectDisks() {
        return suspectDisks;
    }
    
    public void setSuspectDisks(DiskIdList disks) {
        suspectDisks = disks;
    }
    
    @XmlElement(name = "staging_disks")
    public DiskIdList getStagingDisks() {
        return stagingDisks;
    }
    
    public void setStagingDisks(DiskIdList disks) {
        stagingDisks = disks;
    }
    
    @XmlElement(name = "maintenance_mode_disks")
    public DiskIdList getMaintenanceDisks() {
        return maintenanceDisks;
    }
    
    public void setMaintenanceDisks(DiskIdList disks) {
        maintenanceDisks = disks;
    }
   
}
