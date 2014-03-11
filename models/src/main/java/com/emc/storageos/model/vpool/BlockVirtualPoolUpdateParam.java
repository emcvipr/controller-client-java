/**
 * Copyright (c) 2013 EMC Corporation All Rights Reserved This software contains
 * the intellectual property of EMC Corporation or is licensed to EMC
 * Corporation from third parties. Use of this software and the intellectual
 * property contained therein is expressly limited to the terms and conditions
 * of the License Agreement under which it is provided by or on behalf of EMC.
 */

package com.emc.storageos.model.vpool;
import com.emc.storageos.model.valid.Range;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Parameter to update VPool
 */
@XmlRootElement(name = "block_vpool_update")
public class BlockVirtualPoolUpdateParam extends VirtualPoolUpdateParam {
    
    private Integer maxPaths;
    private Integer minPaths;
    private Integer pathsPerInitiator;
    private RaidLevelChanges raidLevelChanges;
    private String autoTieringPolicyName;
    private Integer thinVolumePreAllocationPercentage;
    private String driveType;
    private Boolean multiVolumeConsistency;
    private Boolean expandable;
    private BlockVirtualPoolProtectionUpdateParam protection;
    private VirtualPoolHighAvailabilityParam highAvailability;
    private Boolean uniquePolicyNames ;
    
    public BlockVirtualPoolUpdateParam() {}

    /**
     * The new maximum number of paths to a given storage system for the virtual
     * pool.
     * 
     * @valid none
     */
    @XmlElement(name = "max_paths")
    @Range(min=1,max=65535)
    public Integer getMaxPaths() {
        return maxPaths;
    }

    public void setMaxPaths(Integer maxPaths) {
        this.maxPaths = maxPaths;
    }
    
    @XmlElement(name = "min_paths")
    @Range(min=1,max=65535)
    public Integer getMinPaths() {
        return minPaths;
    }
    
    public void setMinPaths(Integer minPaths) {
        this.minPaths = minPaths;
    }

    /**
     * @deprecated use getMaxPaths instead of getNumPaths
     * @See getMaxPaths()
     * TODO: Remove deprecated API calls in next major release
     */
    @Deprecated
    @XmlElement(name = "num_paths")
    @Range(min=1,max=65535)
    public Integer getNumPaths() {
        return maxPaths;
    }

    /**
     * @deprecated use setMaxPaths instead of setNumPaths
     * @See setMaxPaths() 
     * TODO: Remove deprecated API calls in next major release
     */
    @Deprecated
    public void setNumPaths(Integer numPaths) {
        this.maxPaths = numPaths;
    }

    /**
     * The maximum number of paths to a given storage system for the initiator.
     */
    @XmlElement(name = "paths_per_initiator")
    @Range(min=1,max=65535)
    public Integer getPathsPerInitiator() {
        return pathsPerInitiator;
    }

    public void setPathsPerInitiator(Integer pathsPerInitiator) {
        this.pathsPerInitiator = pathsPerInitiator;
    }

    /**
     * The changes to the supported RAID levels for the virtual pool.
     * 
     * @valid none
     */ 
    @XmlElement(name = "raid_level_changes")
    public RaidLevelChanges getRaidLevelChanges() {
        return raidLevelChanges;
    }

    public void setRaidLevelChanges(RaidLevelChanges raidLevelChanges) {
        this.raidLevelChanges = raidLevelChanges;
    }

    /**
     * The new auto tier policy name for the virtual pool.
     * 
     * @valid none
     */
    @XmlElement(name = "auto_tiering_policy_name", nillable = true)
    public String getAutoTieringPolicyName() {
        return autoTieringPolicyName;
    }

    public void setAutoTieringPolicyName(String autoTieringPolicyName) {
        this.autoTieringPolicyName = autoTieringPolicyName;
    }

    /**
     * The new preallocation size for VMAX thin volumes for the virtual pool.
     * 
     * @valid none
     */
    @XmlElement(name = "thin_volume_preallocation_percentage")
    public Integer getThinVolumePreAllocationPercentage() {
        return thinVolumePreAllocationPercentage;
    }

    public void setThinVolumePreAllocationPercentage(
            Integer thinVolumePreAllocationPercentage) {
        this.thinVolumePreAllocationPercentage = thinVolumePreAllocationPercentage;
    }

    /**
     * The new drive type supported by the virtual pool.
     * 
     * @valid NONE = No specific drive type
     * @valid SSD = Solid State Drive
     * @valid FC = Fibre Channel
     * @valid SAS = Serial Attached SCSI
     * @valid SATA = Serial Advanced Technology Attachment 
     */
    @XmlElement(name = "drive_type")
    public String getDriveType() {
        return driveType;
    }

    public void setDriveType(String driveType) {
        this.driveType = driveType;
    }

    /**
     * Specifies whether or not the virtual pool supports multi-volume
     * consistency.
     * 
     * @valid true
     * @valid false
     */
    @XmlElement(name = "multi_volume_consistency")
    public Boolean getMultiVolumeConsistency() {
        return multiVolumeConsistency;
    }

    public void setMultiVolumeConsistency(Boolean multiVolumeConsistency) {
        this.multiVolumeConsistency = multiVolumeConsistency;
    }

    /**
     * Specifies whether or not the virtual pool supports non-disruptive volume
     * expansion.
     * 
     * @valid true
     * @valid false
     */
    @XmlElement(name = "expandable", required = false)
    public Boolean getExpandable() {
        return expandable;
    }

    public void setExpandable(Boolean expandable) {
        this.expandable = expandable;
    }

    /**
     * The new protection settings for the virtual pool.
     * 
     * @valid none
     */
    @XmlElement(name = "protection")
    public BlockVirtualPoolProtectionUpdateParam getProtection() {
        return protection;
    }

    public void setProtection(BlockVirtualPoolProtectionUpdateParam protection) {
        this.protection = protection;
    }

    /**
     * The new high availability settings for the virtual pool.
     * 
     * @valid none
     */
    @XmlElement(name = "high_availability")
    public VirtualPoolHighAvailabilityParam getHighAvailability() {
        return highAvailability;
    }

    public void setHighAvailability(
            VirtualPoolHighAvailabilityParam highAvailability) {
        this.highAvailability = highAvailability;
    }

    /**
     * Specifies whether or not the virtual pool requires unique auto tier policy names.
     * 
     * @valid true
     * @valid false
     */
    @XmlElement(name = "unique_auto_tier_policy_names", required = false)
    public Boolean getUniquePolicyNames() {
        return uniquePolicyNames;
    }

    public void setUniquePolicyNames(Boolean uniquePolicyNames) {
        this.uniquePolicyNames = uniquePolicyNames;
    }

    /**
     * Convenience method that determines if high availability
     * has been specified.
     * 
     * @return
     */
    public boolean specifiesHighAvailability() {
        return (highAvailability != null && ((HighAvailabilityType.vplex_local
            .name().equals(highAvailability.getType())) || (HighAvailabilityType.vplex_distributed
            .name().equals(highAvailability.getType()))));
    }
    
    /**
     * Convenience method that determines if expansion is set.
     * 
     * @return
     */
    public boolean allowsExpansion() {
        return (expandable != null && expandable);
    }
}
