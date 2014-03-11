/**
 *  Copyright (c) 2008-2013 EMC Corporation
 * All Rights Reserved
 *
 * This software contains the intellectual property of EMC Corporation
 * or is licensed to EMC Corporation from third parties.  Use of this
 * software and the intellectual property contained therein is expressly
 * limited to the terms and conditions of the License Agreement under which
 * it is provided by or on behalf of EMC.
 */

package com.emc.storageos.model.pools;

import com.emc.storageos.model.RelatedResourceRep;
import com.emc.storageos.model.StringHashMapEntry;
import com.emc.storageos.model.varray.VirtualArrayResourceRestRep;

import javax.xml.bind.annotation.*;

import java.util.*;

@XmlRootElement(name = "storage_pool")
@XmlAccessorType(XmlAccessType.PROPERTY)
public class StoragePoolRestRep extends VirtualArrayResourceRestRep {
    private Set<String> protocols;
    private List<StringHashMapEntry> controllerParams;
    private String operationalStatus;
    private String registrationStatus;
    private Long totalCapacity;
    private Long freeCapacity;
    private Long usedCapacity;
    private Long percentUsed;
    private Long subscribedCapacity;
    private Long percentSubscribed;
    private Integer maxResources;
    private Integer numResources;
    private Long maximumThinVolumeSize;
    private Long minimumThinVolumeSize;
    private Long maximumThickVolumeSize;
    private Long minimumThickVolumeSize;
    private Set<String> raidLevels;
    private Set<String> driveTypes;
    private Set<String> copyTypes;
    private List<StringHashMapEntry> tierUtilizationPercentage;
    private String poolName;
    private String poolServiceType;
    private String supportedResourceTypes;
    private RelatedResourceRep storageSystem;
    private Integer maxThinPoolSubscriptionPercentage;
    private Integer maxPoolUtilizationPercentage;
    private Boolean thinVolumePreAllocationSupported;
    private String compatibilityStatus;

    public StoragePoolRestRep() {}
   
    @XmlElementWrapper(name = "controller_params")
    /**
     * The list of optional parameters
     * 
     * @valid none
     */
    @XmlElement(name = "controller_param")
    public List<StringHashMapEntry> getControllerParams() {
        if (controllerParams == null) {
            controllerParams = new ArrayList<StringHashMapEntry>();
        }
        return controllerParams;
    }

    public void setControllerParams(List<StringHashMapEntry> controllerParams) {
        this.controllerParams = controllerParams;
    }

    /**
     * The supported local replication types for this pool
     *
     * @valid none
     */
    @XmlElementWrapper(name = "copy_types")
    /**
     * The type of replication
     *
     * @valid ASYNC          = A copy can be maintained asynchronously
     * @valid SYNC           = A copy can be maintained synchronously
     * @valid UNSYNC_UNASSOC = A full copy can be made, but there is no association between the source and target after making the copy
     * @valid UNSYNC_ASSOC   = A full copy can be made, and there is an association between the source and target after making the copy
     */
    @XmlElement(name = "copy_type")
    public Set<String> getCopyTypes() {
        if (copyTypes == null) {
            copyTypes = new LinkedHashSet<String>();
        }
        return copyTypes;
    }

    public void setCopyTypes(Set<String> copyTypes) {
        this.copyTypes = copyTypes;
    }

    /**
     * The disk drives types in the pool
     *
     * @valid none
     */
    @XmlElementWrapper(name = "drive_types")
    /**
     * The disk drive type
     *
     * @valid FC   = Fibre-Channel
     * @valid SAS  = Serial Attached SCSI
     * @valid SATA = Serial ATA
     */
    @XmlElement(name = "drive_type")
    public Set<String> getDriveTypes() {
        if (driveTypes == null) {
            driveTypes = new LinkedHashSet<String>();
        }
        return driveTypes;
    }

    public void setDriveTypes(Set<String> driveTypes) {
        this.driveTypes = driveTypes;
    }

    /**
     * The amount of free space in the pool (GB)
     *
     * @valid none
     */
    @XmlElement(name = "free_gb")
    public Long getFreeCapacity() {
        return freeCapacity;
    }

    public void setFreeCapacity(Long freeCapacity) {
        this.freeCapacity = freeCapacity;
    }

    /**
     * The maximum number of ViPR storage resources that
     * can exist in this pool
     *
     * @valid none
     */
    @XmlElement(name = "max_resources")
    public Integer getMaxResources() {
        return maxResources;
    }

    public void setMaxResources(Integer maxResources) {
        this.maxResources = maxResources;
    }

    /**
     * The number of ViPR storage resources that exist
     * in this pool
     *
     * @valid none
     */
    @XmlElement(name = "num_resources")
    public Integer getNumResources() {
        return numResources;
    }

    public void setNumResources(Integer numResources) {
        this.numResources = numResources;
    }

    /**
     * The operational status of the pool
     *
     * @valid NOT_READY
     * @valid READY
     *
     */
    @XmlElement(name = "operational_status")
    public String getOperationalStatus() {
        return operationalStatus;
    }

    public void setOperationalStatus(String operationalStatus) {
        this.operationalStatus = operationalStatus;
    }

    /**
     * Whether or not this pool is registered with ViPR. A pool must be
     * registered before it can be managed by ViPR.
     *
     * @valid REGISTERED
     * @valid UNREGISTERED
     */
    @XmlElement(name = "registration_status")
    public String getRegistrationStatus() {
        return registrationStatus;
    }

    public void setRegistrationStatus(String registrationStatus) {
        this.registrationStatus = registrationStatus;
    }

    /**
     * The percentage of usable space that has been assigned to all volumes
     * in the pool  and  visible  to  attached hosts. This includes primary 
     * and snapshot space. (GB)
     *
     * @valid none
     */
    @XmlElement(name = "percent_subscribed")
    public Long getPercentSubscribed() {
        return percentSubscribed;
    }

    public void setPercentSubscribed(Long percentSubscribed) {
        this.percentSubscribed = percentSubscribed;
    }

    /**
     * The percentage of consumed usable space in the pool (GB)
     *
     * @valid none
     */
    @XmlElement(name = "percent_used")
    public Long getPercentUsed() {
        return percentUsed;
    }

    public void setPercentUsed(Long percentUsed) {
        this.percentUsed = percentUsed;
    }

    /**
     * The maximum size for thin volumes in this pool (GB) 
     *
     * @valid none
     */
    @XmlElement(name = "maximum_thin_volume_size_gb")
    public Long getMaximumThinVolumeSize() {
        return maximumThinVolumeSize;
    }

    public void setMaximumThinVolumeSize(Long maximumThinVolumeSize) {
        this.maximumThinVolumeSize = maximumThinVolumeSize;
    }

    /**
     * The minimum size for thin volumes in this pool (GB)
     *
     * @valid none
     */
    @XmlElement(name = "minimum_thin_volume_size_gb")
    public Long getMinimumThinVolumeSize() {
        return minimumThinVolumeSize;
    }

    public void setMinimumThinVolumeSize(Long minimumThinVolumeSize) {
        this.minimumThinVolumeSize = minimumThinVolumeSize;
    }

    /**
     * The maximum size for thick volumes in this pool (GB)
     *
     * @valid none
     */
    @XmlElement(name = "maximum_thick_volume_size_gb")
    public Long getMaximumThickVolumeSize() {
        return maximumThickVolumeSize;
    }

    public void setMaximumThickVolumeSize(Long maximumThickVolumeSize) {
        this.maximumThickVolumeSize = maximumThickVolumeSize;
    }

    /**
     * The minimum size for thick volumes in this pool (GB)
     *
     * @valid none
     */
    @XmlElement(name = "minimum_thick_volume_size_gb")
    public Long getMinimumThickVolumeSize() {
        return minimumThickVolumeSize;
    }

    public void setMinimumThickVolumeSize(Long minimumThickVolumeSize) {
        this.minimumThickVolumeSize = minimumThickVolumeSize;
    }

    /**
     * The native name of the pool. This name is what the hosting storage
     * system uses to identify the pool.
     *
     * @valid none
     */
    @XmlElement(name = "pool_name")
    public String getPoolName() {
        return poolName;
    }

    public void setPoolName(String poolName) {
        this.poolName = poolName;
    }

    /**
     * The ViPR storage resource type that can be provisioned in this pool
     *
     * @valid block  = Volume
     * @valid file   = File System
     * @valid object = Object Store
     */
    @XmlElement(name = "pool_service_type")
    public String getPoolServiceType() {
        return poolServiceType;
    }

    public void setPoolServiceType(String poolServiceType) {
        this.poolServiceType = poolServiceType;
    }

    /**
     * The protocols this pool uses to transport disk commands and
     * responses across its attached networks.
     *
     * @valid none
     */
    @XmlElementWrapper(name = "protocols")
    /**
     * @valid FC = Fibre-Channel
     * @valid IP
     */
    @XmlElement(name = "protocol")
    public Set<String> getProtocols() {
        if (protocols == null) {
            protocols = new LinkedHashSet<String>();
        }
        return protocols;
    }

    public void setProtocols(Set<String> protocols) {
        this.protocols = protocols;
    }

    /**
     * The supported RAID levels for this pool
     *
     * @valid none
     */
    @XmlElementWrapper(name = "raid_levels")
    /**
     * @valid RAID1
     * @valid RAID2
     * @valid RAID3
     * @valid RAID4
     * @valid RAID5
     * @valid RAID6
     * @valid RAID10 = RAID 1/0
     */
    @XmlElement(name = "raid_level")
    public Set<String> getRaidLevels() {
        if (raidLevels == null) {
            raidLevels = new LinkedHashSet<String>();
        }
        return raidLevels;
    }

    public void setRaidLevels(Set<String> raidLevels) {
        this.raidLevels = raidLevels;
    }

    /**
     * The hosting storage system for this pool
     *
     * @valid none
     */
    @XmlElement(name = "storage_system")
    public RelatedResourceRep getStorageSystem() {
        return storageSystem;
    }

    public void setStorageSystem(RelatedResourceRep storageSystem) {
        this.storageSystem = storageSystem;
    }

    /**
     * The total amount of usable space that is configured in the pool
     * and presented to attached hosts (GB)
     *
     * @valid none
     */
    @XmlElement(name = "subscribed_gb")
    public Long getSubscribedCapacity() {
        return subscribedCapacity;
    }

    public void setSubscribedCapacity(Long subscribedCapacity) {
        this.subscribedCapacity = subscribedCapacity;
    }

    /**
     * The volume types that can be created in this pool. A thin volume
     * allocates a portion of its assigned capacity when  it is created
     * and grows as needed. A thick volume allocates all of its
     * assigned capacity when created.
     *
     * @valid THICK_ONLY
     * @valid THIN_ONLY
     * @valid THIN_AND_THICK
     */
    @XmlElement(name = "supported_resource_types")
    public String getSupportedResourceTypes() {
        return supportedResourceTypes;
    }

    public void setSupportedResourceTypes(String supportedResourceTypes) {
        this.supportedResourceTypes = supportedResourceTypes;
    }

    @XmlElementWrapper(name = "tier_utilization_percentages")
    /**
     * The utilization percentages of each storage tier
     * 
     * @valid none
     */
    @XmlElement(name = "tier_utilization_percentage")
    public List<StringHashMapEntry> getTierUtilizationPercentage() {
        if (tierUtilizationPercentage == null) {
            tierUtilizationPercentage = new ArrayList<StringHashMapEntry>();
        }
        return tierUtilizationPercentage;
    }

    public void setTierUtilizationPercentage(List<StringHashMapEntry> tierUtilizationPercentage) {
        this.tierUtilizationPercentage = tierUtilizationPercentage;
    }

    /**
     * The amount of usable space in the pool (GB)
     *
     * @valid none
     */
    @XmlElement(name = "usable_gb")
    public Long getTotalCapacity() {
        return totalCapacity;
    }

    public void setTotalCapacity(Long totalCapacity) {
        this.totalCapacity = totalCapacity;
    }

    /**
     * The amount of consumed usable space in the pool (GB)
     *
     * @valid none
     */
    @XmlElement(name = "used_gb")
    public Long getUsedCapacity() {
        return usedCapacity;
    }

    public void setUsedCapacity(Long usedCapacity) {
        this.usedCapacity = usedCapacity;
    }
    
    /**
     * The user-defined limit for this pool's utilization
     * 
     * @valid none
     */
    @XmlElement(name = "max_pool_utilization_percentage")
    public Integer getMaxPoolUtilizationPercentage() {
        return maxPoolUtilizationPercentage;
    }

    public void setMaxPoolUtilizationPercentage(Integer maxPoolUtilizationPercentage) {
        this.maxPoolUtilizationPercentage = maxPoolUtilizationPercentage;
    }
    
    /**
     * The maximum percentage of usable space that can be assigned to thin volumes
     *
     * @valid none
     */
    @XmlElement(name = "max_thin_pool_subscription_percentage")
    public Integer getMaxThinPoolSubscriptionPercentage() {
        return maxThinPoolSubscriptionPercentage;
    }

    public void setMaxThinPoolSubscriptionPercentage(Integer maxThinPoolSubscription) {
        this.maxThinPoolSubscriptionPercentage = maxThinPoolSubscription;
    }
    
    /**
     * Determines whether pre-allocation of thin volume is supported on this storage pool
     * 
     * @valid true
     * @valid false
     * 
     */
    @XmlElement(name = "thin_volume_preallocation_supported")
    public Boolean getThinVolumePreAllocationSupported() {
        return thinVolumePreAllocationSupported;
    }

    public void setThinVolumePreAllocationSupported(Boolean thinVolumePreAllocationSupported) {
        this.thinVolumePreAllocationSupported = thinVolumePreAllocationSupported;
    }
    
    /**
     * Whether or not this storage pool is compatible with ViPR
     * 
     * @valid COMPATIBLE
     * @valid INCOMPATIBLE
     * @valid UNKNOWN
     */
    @XmlElement(name = "compatibility_status")
    public String getCompatibilityStatus() {
        return compatibilityStatus;
    }

    public void setCompatibilityStatus(String compatibilityStatus) {
        this.compatibilityStatus = compatibilityStatus;
    }
}
