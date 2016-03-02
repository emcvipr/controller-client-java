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

import com.emc.storageos.model.RelatedResourceRep;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import org.codehaus.jackson.annotate.JsonProperty;

@XmlRootElement(name = "vpool_list")
public class VirtualPoolList {

    private List<NamedRelatedVirtualPoolRep> virtualPool;

    public VirtualPoolList() {}
    
    public VirtualPoolList(List<NamedRelatedVirtualPoolRep> virtualPool) {
        this.virtualPool = virtualPool;
    }

    /**
     * The list of virtual pool response instances.
     * 
     * @valid none
     */
    @XmlElement(name = "virtualpool")
    @JsonProperty("virtualpool")
    public List<NamedRelatedVirtualPoolRep> getVirtualPool() {
        if (virtualPool == null) {
            virtualPool = new ArrayList<NamedRelatedVirtualPoolRep>();
        }
        return virtualPool;
    }

    public void setVirtualPool(List<NamedRelatedVirtualPoolRep> virtualPool) {
        this.virtualPool = virtualPool;
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
    public boolean containsVirtualPoolResource(String virtualPoolId) {
        for (RelatedResourceRep vpoolListResource : getVirtualPool()) {
            URI vpoolListResourceId = vpoolListResource.getId();
            if ((vpoolListResourceId != null)
                && (vpoolListResourceId.toString().equals(virtualPoolId))) {
                return true;
            }
        }
        return false;
    }
}
