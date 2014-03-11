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

package com.emc.storageos.model.block;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

import org.codehaus.jackson.annotate.JsonProperty;

import com.emc.storageos.model.RelatedResourceRep;

@XmlAccessorType(XmlAccessType.PROPERTY)
@XmlRootElement(name = "volume")
public class VolumeRestRep extends BlockObjectRestRep {
    private RelatedResourceRep project;
    private RelatedResourceRep tenant;
    private String provisionedCapacity;
    private String allocatedCapacity;
    private String capacity;
    private String preAllocationSize;
    private boolean isComposite;
    private RelatedResourceRep vpool;
    private Boolean thinlyProvisioned;
    private RelatedResourceRep autoTierPolicyUri;
    private List<RelatedResourceRep> haVolumes;
    private ProtectionRestRep protection;

    // Fields in a Volume that are specific to RecoverPoint
    public static class RecoverPointRestRep {
        private List<RelatedResourceRep> rpTargets;
        private RelatedResourceRep protectionSet;
        private RelatedResourceRep protectionSystem;
        private String internalSiteName;
        private String copyName;
        private String rsetName;
        private String personality;

        /**
         * This volume's RecoverPoint (RP) target copies
         *
         * @valid none
         */
        @XmlElementWrapper(name = "targets")
        /**
         * A RecoverPoint (RP) target copy
         *
         * @valid none
         */
        @XmlElement(name = "target")
        public List<RelatedResourceRep> getRpTargets() {
            if (rpTargets == null) {
                rpTargets = new ArrayList<RelatedResourceRep>();
            }
            return rpTargets;
        }

        public void setRpTargets(List<RelatedResourceRep> rpTargets) {
            this.rpTargets = rpTargets;
        }

                /**
                 * This volume's RecoverPoint (RP) consistency group
                 *
                 * @valid none
                 */
        @XmlElement(name = "protection_set")
        public RelatedResourceRep getProtectionSet() {
            return protectionSet;
        }

        public void setProtectionSet(RelatedResourceRep protectionSet) {
            this.protectionSet = protectionSet;
        }

            /**
             * This volume's RecoverPoint appliance (RPA)
             *
             * @valid none
             */
        @XmlElement(name = "protection_system")
        public RelatedResourceRep getProtectionSystem() {
            return protectionSystem;
        }

        public void setProtectionSystem(RelatedResourceRep protectionSystem) {
            this.protectionSystem = protectionSystem;
        }

            /**
             * A label that can be used to denote the physical location of the volume
             *
             * @valid none
             */
        @XmlElement(name = "site_name")
        public String getInternalSiteName() {
            return internalSiteName;
        }

        public void setInternalSiteName(String internalSiteName) {
            this.internalSiteName = internalSiteName;
        }

            /**
             * The volume's RecoverPoint (RP) copy name. In this context, a
             * production volume is a  copy  that is used as a  source  for
             * replication.
             *
             * @valid none
             */
        @XmlElement(name = "copy_name")
        public String getCopyName() {
            return copyName;
        }

        public void setCopyName(String copyName) {
            this.copyName = copyName;
        }

            /**
             * The name of this volume's  RecoverPoint  (RP)  replication set. A
             * replication set consists of a production volume and that volume's
             * target copies.
             *
             * @valid none
             */
        @XmlElement(name = "replicationset_name")
        public String getRsetName() {
            return rsetName;
        }

        public void setRsetName(String rsetName) {
            this.rsetName = rsetName;
        }

            /**
             * How this volume is used with respect to replication
             *
             * @valid SOURCE   = A production volume
             * @valid TARGET   = A copy of a production volume
             * @valid METADATA = A volume that stores meta-data for replication. Example: A RecoverPoint journal volume
             */
        @XmlElement(name = "personality")
        public String getPersonality() {
            return personality;
        }

        public void setPersonality(String personality) {
            this.personality = personality;
        }
    }

    // Fields in a volume that are specific to native mirrors
    public static class MirrorRestRep {
        private List<RelatedResourceRep> mirrors;

        @XmlElementWrapper(name = "native_mirrors")
        
        /**
         * List of mirrors - VMAX BCVs or VNX SnapView Clones.
         * @valid none
         */
        @XmlElement(name = "native_mirror")
        public List<RelatedResourceRep> getMirrors() {
            if (mirrors == null) {
                mirrors = new ArrayList<RelatedResourceRep>();
            }
            return mirrors;
        }

        public void setMirrors(List<RelatedResourceRep> mirrors) {
            this.mirrors = mirrors;
        }
    }

    // Fields in a volume that are specific to full copies of another volume
    public static class FullCopyRestRep {
        private RelatedResourceRep associatedSourceVolume;
        private List<RelatedResourceRep> fullCopyVolumes;
        private Boolean isSyncActive;
        private Integer percentSynced;

        @XmlElement(name = "associated_source_volume")
        public RelatedResourceRep getAssociatedSourceVolume() {
            return associatedSourceVolume;
        }

        public void setAssociatedSourceVolume(RelatedResourceRep associatedSourceVolume) {
            this.associatedSourceVolume = associatedSourceVolume;
        }

        @XmlElementWrapper(name = "volumes")
        @XmlElement(name = "volume")
        public List<RelatedResourceRep> getFullCopyVolumes() {
            if (fullCopyVolumes == null) {
                fullCopyVolumes = new ArrayList<RelatedResourceRep>();
            }
            return fullCopyVolumes;
        }

        public void setFullCopyVolumes(List<RelatedResourceRep> fullCopyVolumes) {
            this.fullCopyVolumes = fullCopyVolumes;
        }

        @XmlElement(name = "is_sync_active")
        public Boolean getSyncActive() {
            return isSyncActive;
        }

        public void setSyncActive(Boolean syncActive) {
            isSyncActive = syncActive;
        }

        @XmlElement(name = "percent_synced")
        public Integer getPercentSynced() {
            return percentSynced;
        }

        public void setPercentSynced(Integer percentSynced) {
            this.percentSynced = percentSynced;
        }
    }

    // Fields in a volume that are specific to SRDF Copies
    public static class SRDFRestRep {
        private RelatedResourceRep associatedSourceVolume;
        private List<RelatedResourceRep> targetVolumes;

        @XmlElement(name = "associated_source_volume")
        public RelatedResourceRep getAssociatedSourceVolume() {
            return associatedSourceVolume;
        }

        public void setAssociatedSourceVolume(RelatedResourceRep associatedSourceVolume) {
            this.associatedSourceVolume = associatedSourceVolume;
        }

        @XmlElementWrapper(name = "volumes")
        @XmlElement(name = "volume")
        public List<RelatedResourceRep> getSRDFTargetVolumes() {
            if (targetVolumes == null) {
                targetVolumes = new ArrayList<RelatedResourceRep>();
            }
            return targetVolumes;
        }

        public void setSRDFTargetVolumes(List<RelatedResourceRep> targetVolumes) {
            this.targetVolumes = targetVolumes;
        }
    }

    // Fields specific to protection characteristics of the Volume
    public static class ProtectionRestRep {
        private MirrorRestRep mirrorRep;
        private RecoverPointRestRep rpRep;
        private FullCopyRestRep fullCopyRep;
        private SRDFRestRep srdfRep;

        /**
         * Information related to native mirroring
         *
         * @valid none
         */
        @XmlElement(name = "mirrors")
        public MirrorRestRep getMirrorRep() {
            return mirrorRep;
        }

        public void setMirrorRep(MirrorRestRep mirrorRep) {
            this.mirrorRep = mirrorRep;
        }
    
        /**
         * Information related to RecoverPoint (RP) replication
         *
         * @valid none
         */    
        @XmlElement(name = "recoverpoint")
        public RecoverPointRestRep getRpRep() {
            return rpRep;
        }

        public void setRpRep(RecoverPointRestRep rpRep) {
            this.rpRep = rpRep;
        }

        /**
         * Information related to clone replication
         *
         * @valid none
         */    
        @XmlElement(name = "full_copies")
        public FullCopyRestRep getFullCopyRep() {
            return fullCopyRep;
        }

		public void setFullCopyRep(FullCopyRestRep fullCopyRestRep) {
            this.fullCopyRep = fullCopyRestRep;
        }

        /**
         * Information related to SRDF replication
         *
         * @valid none
         */    
        @XmlElement(name = "srdf")
        public SRDFRestRep getSrdfRep() {
			return srdfRep;
		}

		public void setSrdfRep(SRDFRestRep srdfRep) {
			this.srdfRep = srdfRep;
		}

    }
    
    /**
     * The total amount of space allocated from the volume's storage pool (GB)
     *
     * @valid none
     */
    @XmlElement(name = "allocated_capacity_gb")
    public String getAllocatedCapacity() {
        return allocatedCapacity;
    }

    public void setAllocatedCapacity(String allocatedCapacity) {
        this.allocatedCapacity = allocatedCapacity;
    }
    
    /**
     * The amount of space that was initially allocated when the volume was created (GB)
     *
     * @valid none
     */
    @XmlElement(name = "pre_allocation_size_gb")
    public String getPreAllocationSize() {
        return preAllocationSize;
    }

    public void setPreAllocationSize(String preAllocationSize) {
        this.preAllocationSize = preAllocationSize;
    }

    /**
     * The policy used to distribute data across the disks of
     * the volume's storage pool
     *
     * @valid DEFAULT_NO_MOVEMENT       = Data is never relocated from the disks it is originally written to
     * @valid DEFAULT_AUTOTIER          = Data is relocated based on its activity level
     * @valid DEFAULT_HIGHEST_AVAILABLE = Data is kept on the fastest disks available
     * @valid DEFAULT_LOWEST_AVAILABLE  = Data is kept on the slowest disks available
     */
    @XmlElement(name = "auto_tier_policy")
    public RelatedResourceRep getAutoTierPolicyUri() {
        return autoTierPolicyUri;
    }

    public void setAutoTierPolicyUri(RelatedResourceRep autoTierPolicy) {
        this.autoTierPolicyUri= autoTierPolicy;
    }

    /**
     * This volume's total capacity in Gb (Gigabytes).
     * @valid none
     */
    @XmlElement(name = "requested_capacity_gb")
    public String getCapacity() {
        return capacity;
    }

    public void setCapacity(String capacity) {
        this.capacity = capacity;
    }

    /**
     * This volume's virtual pool
     *
     * @valid none
     */
    @XmlElement(name = "vpool")
    @JsonProperty("vpool")
    public RelatedResourceRep getVirtualPool() {
        return vpool;
    }

    public void setVirtualPool(RelatedResourceRep vpool) {
        this.vpool = vpool;
    }

    /**
     * Specifies whether this is a composite (meta) volume. 
     * @valid true
     * @valid false
     */
    @XmlElement(name = "is_composite")
    public Boolean getIsComposite() {
        return isComposite;
    }

    public void setIsComposite(Boolean isComposite) {
        this.isComposite = isComposite;
    }

    /**
     * This volume's project
     *
     * @valid none
     */
    @XmlElement
    public RelatedResourceRep getProject() {
        return project;
    }

    public void setProject(RelatedResourceRep project) {
        this.project = project;
    }

    /**
     * This volume's logical capacity in Gb (Gigabytes).
     * @valid none
     */
    @XmlElement(name = "provisioned_capacity_gb")
    public String getProvisionedCapacity() {
        return provisionedCapacity;
    }

    public void setProvisionedCapacity(String provisionedCapacity) {
        this.provisionedCapacity = provisionedCapacity;
    }

    /**
     * This volume's tenant
     *
     * @valid none
     */
    @XmlElement
    public RelatedResourceRep getTenant() {
        return tenant;
    }

    public void setTenant(RelatedResourceRep tenant) {
        this.tenant = tenant;
    }

    /**
     * Whether or not this volume is thinly provisioned. A thin
     * volume  initially  allocates  a  portion of its assigned
     * capacity when it is created and then grows as needed.
     *
     * @valid true
     * @valid false
     */
    @XmlElement(name = "thinly_provisioned")
    public Boolean getThinlyProvisioned() {
        return thinlyProvisioned;
    }

    public void setThinlyProvisioned(Boolean thinlyProvisioned) {
        this.thinlyProvisioned = thinlyProvisioned;
    }

    @XmlElementWrapper(name = "high_availability_backing_volumes")
    /**
     * List of volumes acting as backing volumes in case of fail-over.
     * @valid none
     */
    @XmlElement(name = "high_availability_backing_volume")
    public List<RelatedResourceRep> getHaVolumes() {
        if (haVolumes == null) {
            haVolumes = new ArrayList<RelatedResourceRep>();
        }
        return haVolumes;
    }

    public void setHaVolumes(List<RelatedResourceRep> haVolumes) {
        this.haVolumes = haVolumes;
    }

        /**
         * Information on how this volume is protected
         *
         * @valid none
         */
    public ProtectionRestRep getProtection() {
        return protection;
    }

    public void setProtection(ProtectionRestRep protection) {
        this.protection = protection;
    }

}
