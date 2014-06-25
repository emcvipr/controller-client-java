/*
 * Copyright (c) 2014 EMC Corporation
 * All Rights Reserved
 *
 * This software contains the intellectual property of EMC Corporation
 * or is licensed to EMC Corporation from third parties.  Use of this
 * software and the intellectual property contained therein is expressly
 * limited to the terms and conditions of the License Agreement under which
 * it is provided by or on behalf of EMC.
 */
package com.emc.vipr.model.object.cashead;

import javax.xml.bind.annotation.XmlElement;
import java.util.List;

/**
 * CAS cluster is an object that brings additional CAS-specific configuration on namespace
 * There is one-to-one mapping between namespace and cluster, each namespace may have one CAS cluster
 */
public abstract class CasCluster {

    private String name;

    private List<String> clusterMask;

    private List<String> accessNodes;

    /**
     * Name of the cluster
     */
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    /**
     * Mask reflects set of operations allowed on this cluster like read, write or delete
     */
    @XmlElement(name = "cluster_mask")
    public List<String> getClusterMask() {
        return clusterMask;
    }

    public void setClusterMask(List<String> clusterMask) {
        this.clusterMask = clusterMask;
    }

    /**
     * List of data nodes in this CAS cluster
     */
    @XmlElement(name = "access_nodes")
    public List<String> getAccessNodes() {
        return accessNodes;
    }

    public void setAccessNodes(List<String> accessNodes) {
        this.accessNodes = accessNodes;
    }
}
