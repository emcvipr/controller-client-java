/*
 * Copyright 2015 EMC Corporation
 * All Rights Reserved
 */
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

package com.emc.storageos.model.vpool;

import com.emc.storageos.model.NamedRelatedResourceRep;
import com.emc.storageos.model.RelatedResourceRep;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import org.codehaus.jackson.annotate.JsonProperty;

@XmlRootElement(name = "compute_vpool_list")
public class ComputeVirtualPoolList {

    private List<NamedRelatedResourceRep> computeVirtualPool;

    public ComputeVirtualPoolList() {}
    
    public ComputeVirtualPoolList(List<NamedRelatedResourceRep> computeVirtualPool) {
        this.computeVirtualPool = computeVirtualPool;
    }

    /**
     * The list of virtual pool response instances.
     * 
     * @valid none
     */
    @XmlElement(name = "computevirtualpool")
    @JsonProperty("computevirtualpool")
    public List<NamedRelatedResourceRep> getComputeVirtualPool() {
        if (computeVirtualPool == null) {
            computeVirtualPool = new ArrayList<NamedRelatedResourceRep>();
        }
        return computeVirtualPool;
    }

    public void setVirtualPool(List<NamedRelatedResourceRep> computeVirtualPool) {
        this.computeVirtualPool = computeVirtualPool;
    }

    /**
     * Determines whether or not the list contains a virtual pool resource with the
     * passed id.
     * 
     * @param virtualPoolId The virtual pool id to check.
     * 
     * @return true if the list contains a virtual pool resource with the passed id,
     *         false otherwise.
     */
    public boolean containsVirtualPoolResource(String computeVirtualPoolId) {
        for (RelatedResourceRep vpoolListResource : getComputeVirtualPool()) {
            URI vpoolListResourceId = vpoolListResource.getId();
            if ((vpoolListResourceId != null)
                && (vpoolListResourceId.toString().equals(computeVirtualPoolId))) {
                return true;
            }
        }
        return false;
    }
}
