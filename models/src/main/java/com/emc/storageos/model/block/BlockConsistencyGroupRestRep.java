package com.emc.storageos.model.block;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

import com.emc.storageos.model.DataObjectRestRep;
import com.emc.storageos.model.RelatedResourceRep;
import org.codehaus.jackson.annotate.JsonProperty;

@XmlAccessorType(XmlAccessType.PROPERTY)
@XmlRootElement(name = "consistency_group")
public class BlockConsistencyGroupRestRep extends DataObjectRestRep {

    private List<RelatedResourceRep> volumes;
    private RelatedResourceRep storageController;
    private RelatedResourceRep project;
    private RelatedResourceRep virtualArray;
    private String deviceName;

    /**
     * Related storage controller
     *
     * @valid none
     */
    @XmlElement(name = "storage_controller")
    public RelatedResourceRep getStorageController() {
        return storageController;
    }

    public void setStorageController(RelatedResourceRep storageController) {
        this.storageController = storageController;
    }

    /**
     * Related project
     *
     * @valid none
     */
    @XmlElement(name = "project")
    public RelatedResourceRep getProject() {
        return project;
    }

    public void setProject(RelatedResourceRep project) {
        this.project = project;
    }

    /**
     * Related virtual array
     *
     * @valid none
     */
    @XmlElement(name = "varray")
    @JsonProperty("varray")
    public RelatedResourceRep getVirtualArray() {
        return virtualArray;
    }

    public void setVirtualArray(RelatedResourceRep virtualArray) {
        this.virtualArray = virtualArray;
    }

    @XmlElementWrapper(name = "volumes")
    /**
     * A volume that exists within the block consistency group
     *
     * @valid none
     */
    @XmlElement(name = "volume")
    public List<RelatedResourceRep> getVolumes() {
        if (volumes == null) {
            volumes = new ArrayList<RelatedResourceRep>();
        }
        return volumes;
    }

    public void setVolumes(List<RelatedResourceRep> volumes) {
        this.volumes = volumes;
    }

    /**
     * The device name for the block consistency group
     *
     * @valid none
     */
    @XmlElement(name = "device_name")
    public String getDeviceName(){ 
        return deviceName; 
    }
    
    public void setDeviceName(String deviceName) { 
        this.deviceName = deviceName;
    }
}
