/*
 * Copyright (c) 2016 EMC Corporation
 * All Rights Reserved
 */
package com.emc.storageos.model.application;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

import com.emc.storageos.model.block.SnapshotSessionUnlinkTargetParam;

/**
 * Class that captures the POST data passed in a request to unlink
 * target volumes from an existing block snapshot sessions in a volume group.
 */
@XmlRootElement(name = "volume_group_snapshot_session_unlink_targets")
public class VolumeGroupSnapshotSessionUnlinkTargetsParam extends VolumeGroupSnapshotSessionOperationParam {

    // The list of targets to be unlinked.
    private List<SnapshotSessionUnlinkTargetParam> linkedTargets;
    
    // use instead of list of target volumes
    private String targetName;
    
    private Boolean deleteTarget;

    /**
     * Default constructor.
     */
    public VolumeGroupSnapshotSessionUnlinkTargetsParam() {
    }

    /**
     * Constructor.
     * 
     * @param linkedTargets The list of targets to be unlinked.
     */
    public VolumeGroupSnapshotSessionUnlinkTargetsParam(List<SnapshotSessionUnlinkTargetParam> linkedTargets) {
        this.linkedTargets = linkedTargets;
    }

    @XmlElementWrapper(name = "linked_targets", required = false)
    /**
     * Gets the list of targets to be unlinked.
     * 
     * @valid none
     * 
     * @return The list of targets to be unlinked.
     */
    @XmlElement(name = "linked_target", required = false)
    public List<SnapshotSessionUnlinkTargetParam> getLinkedTargets() {
        return linkedTargets;
    }

    /**
     * Sets the list of targets to be unlinked.
     * 
     * @param linkedTargets The list of targets to be unlinked.
     */
    public void setLinkedTargets(List<SnapshotSessionUnlinkTargetParam> linkedTargets) {
        this.linkedTargets = linkedTargets;
    }

    /**
     * @return the targetName
     */
    @XmlElement(name = "target_name", required = false)
    public String getTargetName() {
        return targetName;
    }

    /**
     * @param targetName the targetName to set
     */
    public void setTargetName(String targetName) {
        this.targetName = targetName;
    }

    /**
     * @return the deleteTarget
     */
    @XmlElement(name = "delete_target", required = false, defaultValue = "false")
    public Boolean getDeleteTarget() {
        return deleteTarget;
    }

    /**
     * @param deleteTarget the deleteTarget to set
     */
    public void setDeleteTarget(Boolean deleteTarget) {
        this.deleteTarget = deleteTarget;
    }
}
