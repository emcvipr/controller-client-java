/*
 * Copyright 2015 EMC Corporation
 * All Rights Reserved
 */
package com.emc.storageos.model.block;

import java.net.URI;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

import com.emc.storageos.model.DataObjectRestRep;
import com.emc.storageos.model.RelatedResourceRep;
import com.emc.storageos.model.adapters.StringSetMapAdapter;

import org.codehaus.jackson.annotate.JsonProperty;

@XmlAccessorType(XmlAccessType.PROPERTY)
@XmlRootElement(name = "consistency_group")
public class BlockConsistencyGroupRestRep extends DataObjectRestRep {

    private List<RelatedResourceRep> volumes;
    private RelatedResourceRep storageController;
    private RelatedResourceRep project;
    private RelatedResourceRep virtualArray;
    private Set<String> types;
    private String linkStatus;

    // RecoverPoint fields
    private URI rpProtectionSystem;
    private String rpConsistenyGroupId;

    // VPlex fields
    private List<StringSetMapAdapter.Entry> systemConsistencyGroups;
    
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
     * The mapping of protection systems/storage systems to consistency groups that
     * are mapped to by the BlockConsistencyGroup.
     *
     * @valid none
     */
    @XmlElement(name = "system_consistency_groups")
    public List<StringSetMapAdapter.Entry> getSystemConsistencyGroups(){ 
        return systemConsistencyGroups; 
    }
    
    public void setSystemConsistencyGroups(List<StringSetMapAdapter.Entry> systemConsistencyGroups) { 
        this.systemConsistencyGroups = systemConsistencyGroups;
    }    
    
    /**
     * The types of the block consistency group
     *
     * @valid none
     */
    @XmlElement(name = "types")
    public Set<String> getTypes(){ 
        if (types == null) {
            types = new HashSet<String>();
        }
        return types;
    }
    
    public void setTypes(Set<String> types) { 
        this.types = types;
    }
    
    /**
     * The RecoverPoint protection system.  Applies only to CGs of type RP.
     *
     * @valid none
     */
    @XmlElement(name = "rp_protection_system")
    public URI getRpProtectionSystem() {
        return rpProtectionSystem;
    }

    public void setRpProtectionSystem(URI rpProtectionSystem) {
        this.rpProtectionSystem = rpProtectionSystem;
    }

    /**
     * The RecoverPoint consistency group id.  Applies only to CGs of type RP.
     *
     * @valid none
     */    
    @XmlElement(name = "rp_consistency_group_id")
    public String getRpConsistenyGroupId() {
        return rpConsistenyGroupId;
    }

    public void setRpConsistenyGroupId(String rpConsistenyGroupId) {
        this.rpConsistenyGroupId = rpConsistenyGroupId;
    }

    /**
     * The link status.
     *
     * @valid none
     */
    @XmlElement(name = "link_status")
    public String getLinkStatus() {
        return linkStatus;
    }

    public void setLinkStatus(String linkStatus) {
        this.linkStatus = linkStatus;
    }
}
