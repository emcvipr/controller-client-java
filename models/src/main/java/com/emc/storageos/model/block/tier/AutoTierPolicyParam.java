/*
 * Copyright (c) 2008-2013 EMC Corporation
 * All Rights Reserved
 */
package com.emc.storageos.model.block.tier;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "auto_tier_policies_get")
public class AutoTierPolicyParam {

    private String provisioningType;

    public AutoTierPolicyParam() {
    }

    public AutoTierPolicyParam(String provisioningType) {
        this.provisioningType = provisioningType;
    }

    /**
     * The provisioning type of the auto tiering policy
     * Valid values:
     * Thin
     * Thick
     * All
     * 
     */
    @XmlElement(name = "provisioning_type", required = false)
    public String getProvisioningType() {
        return provisioningType;
    }

    public void setProvisioningType(String provisioningType) {
        this.provisioningType = provisioningType;
    }

}
